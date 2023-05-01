package ru.netology.javaqa;

public class NotFoundException extends RuntimeException {
    public NotFoundException (String id) {
        super("Element with id: " + id + " not found");
    }

}
