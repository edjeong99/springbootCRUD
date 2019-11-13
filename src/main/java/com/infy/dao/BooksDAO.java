package com.infy.dao;

import java.util.List;

import com.infy.model.Book;

public interface BooksDAO {
	public List<Book> getAllBooks() throws Exception;
	public Book addBook(Book book);
	public Book updateBook(Book book);
	public Book deleteBook(Integer id);
}
