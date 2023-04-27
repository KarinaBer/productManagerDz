package ru.netology.javaqa.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.domain.Book;
import ru.netology.javaqa.domain.Product;
import ru.netology.javaqa.domain.Smartphone;
import ru.netology.javaqa.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Product book1 = new Book(1, "Стихи", 300, "Есенин");
    private Product book2 = new Book(2, "Рассказы", 400, "Чехов");
    private Product book3 = new Book(3, "Сказки", 555, "Пушкин");
    private Product book4 = new Book(33, "Сказки", 600, "Андерсен");
    private Product smartphone1 = new Smartphone(4, "A57", 30000, "Samsung");
    private Product smartphone2 = new Smartphone(5, "I8", 35000, "Honor");
    private Product smartphone3 = new Smartphone(6, "XR", 45000, "Iphone");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldReverseAllProducts() {
        Product[] expected = {book1,book2,book3, book4, smartphone1,smartphone2,smartphone3};
        Product[] actual = manager.getAll();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldFindBookByName() {

        Product[] expected = new Product[] {book1};
        Product[] actual = manager.searchBy("Стихи");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldFindSomeBookByName() {

        Product[] expected = new Product[] {book3, book4};
        Product[] actual = manager.searchBy("Сказки");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldFindSmartphoneByName() {

        Product[] expected = new Product[] {smartphone3};
        Product[] actual = manager.searchBy("XR");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldNotFindAnything() {

        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy("Басни");

        Assertions.assertArrayEquals(expected,actual);
    }

}
