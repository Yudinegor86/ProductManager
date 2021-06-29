package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository productRepository = new ProductRepository();
    ProductManager productManager = new ProductManager(productRepository);

    Book book1 = new Book(0, "The Hobbit, or There and Back Again", 132, "Tolkien");
    Book book2 = new Book(1, "The Chronicles Of Narnia", 99, "Jeff Marsden");
    Smartphone smartphone1 = new Smartphone(2, "Toshiba K01", 31500, "Toshiba");
    Smartphone smartphone2 = new Smartphone(3, "P40 128Gb", 7200, "Huawei");
    TShirt tShirt = new TShirt(5, "Classic Fit", 1500, "red","25");

    @Test
    void searchByMany() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(tShirt);

        assertArrayEquals(new Product[]{book1,smartphone1},productManager.searchBy("To"));
    }

    @Test
    void searchByOneTrue() {
        productManager.add(book1);

        assertArrayEquals(new Product[]{book1},productManager.searchBy("The Hobbit"));
    }

    @Test
    void searchByOneFalse() {
        productManager.add(book2);

        assertArrayEquals(new Product[]{},productManager.searchBy("Tolkien"));
    }

    @Test
    void searchByZero() {
        assertArrayEquals(new Product[]{},productManager.searchBy("Apple"));
    }
}