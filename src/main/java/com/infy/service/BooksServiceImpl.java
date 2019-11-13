package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.BooksDAO;
import com.infy.model.Book;

@Service(value="BooksServiceImpl")
@Transactional
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksDAO bookDao; 

	@Override
	public List<Book> getAllBooks() throws Exception {
		return bookDao.getAllBooks();
	}

	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}
	
	public Book updateBook(Book book) {
		return bookDao.updateBook(book);
	}
	public Book deleteBook(Integer id) {
		return bookDao.deleteBook(id);
	}
	
}
