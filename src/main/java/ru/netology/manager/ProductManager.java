package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    ProductRepository productRepository;

    ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (((Book) product).getAuthor().contains(search)) {
                return true;
            }
            return product.getName().contains(search);
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (((Smartphone) product).getManufacturer().contains(search)) {
                return true;
            }
            return product.getName().contains(search);
        }
        return false;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : productRepository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}