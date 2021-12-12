package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    void shouldSearchNameBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Букварь", 230, "Надежда Жукова");
        Book book2 = new Book(2, "Земля Королей. Трефовый том", 123, "Фёдор Комикс");
        Book book3 = new Book(3, "Внутри убийцы", 456, "Майк Омер");
        Book book4 = new Book(4, "Безмолвный пациент", 844, "Алекс Михаэлидес");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("Букварь");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAuthorBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Букварь", 230, "Надежда Жукова");
        Book book2 = new Book(2, "Земля Королей. Трефовый том", 123, "Фёдор Комикс");
        Book book3 = new Book(3, "Внутри убийцы", 456, "Майк Омер");
        Book book4 = new Book(4, "Безмолвный пациент", 844, "Алекс Михаэлидес");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("Майк Омер");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameTwoBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Букварь", 230, "Надежда Жукова");
        Book book2 = new Book(2, "Земля Королей. Трефовый том", 123, "Фёдор Комикс");
        Book book3 = new Book(3, "Внутри убийцы", 456, "Майк Омер");
        Book book4 = new Book(4, "Букварь", 844, "Алекс Михаэлидес");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("Букварь");
        Product[] expected = new Product[]{book1, book4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "iPhone 11", 10000, "Китай");
        Smartphone smartphone2 = new Smartphone(2, "iPhone 12", 100000, "США");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("iPhone 12");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchManufacturerSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "iPhone 11", 10000, "Китай");
        Smartphone smartphone2 = new Smartphone(2, "iPhone 12", 100000, "США");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("Китай");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameTwoSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "iPhone 11", 10000, "Китай");
        Smartphone smartphone2 = new Smartphone(2, "iPhone 12", 100000, "США");
        Smartphone smartphone3 = new Smartphone(2, "iPhone 12", 100000, "США");
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual = manager.searchBy("iPhone 12");
        Product[] expected = new Product[]{smartphone2, smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookAndSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Букварь>", 230, "Надежда Жукова");
        Book book2 = new Book(2, "iPhone 11", 123, "Фёдор Комикс");
        Book book3 = new Book(3, "Внутри убийцы", 456, "Майк Омер");
        Book book4 = new Book(4, "Букварь", 844, "Алекс Михаэлидес");
        Smartphone smartphone1 = new Smartphone(1, "iPhone 11", 10000, "Китай");
        Smartphone smartphone2 = new Smartphone(2, "iPhone 12", 100000, "США");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("iPhone 11");
        Product[] expected = new Product[]{book2, smartphone1};
        assertArrayEquals(expected, actual);
    }
}
