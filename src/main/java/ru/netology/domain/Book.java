package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
  private String author;

  public Book() {
    super();
  }

  public Book(int id, String name, int price, String author) {
    super(id, name, price);
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  @Override
  public String toString() {
    return "Book{" +
            "author=" + author +
            '}';
  }

  public boolean matches(Product product, String search) {
    if (product instanceof Book) {
      Book book = (Book) product;
      if (book.getName().equalsIgnoreCase(search)) {
        return true;
      }
      if (book.getAuthor().equalsIgnoreCase(search)) {
        return true;
      }
      return false;
    } else {return false;}
  }
}
