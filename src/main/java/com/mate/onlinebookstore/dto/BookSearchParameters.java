package com.mate.onlinebookstore.dto;

public record BookSearchParameters(String[] titles, String[] authors, String[] isbn) {
}
