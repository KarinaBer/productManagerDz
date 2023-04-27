package ru.netology.javaqa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.domain.Book;
import ru.netology.javaqa.domain.Product;
import ru.netology.javaqa.domain.Smartphone;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product book1 = new Book(1, "Стихи", 300, "Есенин");
    private Product book2 = new Book(2, "Рассказы", 400, "Чехов");
    private Product book3 = new Book(3, "Сказки", 555, "Пушкин");
    private Product smartphone1 = new Smartphone(4, "A57", 30000, "Samsung");
    private Product smartphone2 = new Smartphone(5, "I8", 35000, "Honor");
    private Product smartphone3 = new Smartphone(6, "XR", 45000, "Iphone");

    @Test
    public void shouldAddAllProducts() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        Product[] expected = new Product[] {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldAddSomeProducts() {
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone3);

        Product[] expected = new Product[]{book1, book2, smartphone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotAddAnything() {
        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        repository.removeById(1);
        repository.removeById(3);
        repository.removeById(6);

        Product[] expected = new Product[]{book2,smartphone1,smartphone2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldRemoveByIdOneProduct() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        repository.removeById(1);

        Product[] expected = new Product[]{book2,book3,smartphone1,smartphone2,smartphone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldRemoveByIdTwoProducts() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        repository.removeById(1);
        repository.removeById(2);

        Product[] expected = new Product[]{book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveByIdAllProducts() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        repository.removeById(1);
        repository.removeById(2);
        repository.removeById(3);
        repository.removeById(4);
        repository.removeById(5);
        repository.removeById(6);

        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
}
