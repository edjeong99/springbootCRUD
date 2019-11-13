package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.BookEntity;
import com.infy.model.Book;

@Repository
public class BooksDAOImpl implements BooksDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Book> getAllBooks() throws Exception {
		
		Query query = entityManager.createQuery("select book FROM BookEntity book");
		List<Book> books = null;			
		
		List<BookEntity> bookEntities = query.getResultList();		
		books = new ArrayList<Book>();

		for (BookEntity bookEntity  : bookEntities) {
			Book book = new Book();
			book.setBookId(bookEntity.getBookId());
			book.setBookName(bookEntity.getBookName());
			//book.setMessage(bookEntity.g);
			books.add(book);
		}
		return books;
	}
	@Override
	public Book addBook(Book book) {
		BookEntity be = new BookEntity();
		be.setBookName(book.getBookName());
		
		entityManager.persist(be);
		book.setBookId(be.getBookId());
		return book;
	}
	@Override
	public Book updateBook(Book book) {
		BookEntity be = entityManager.find(BookEntity.class, book.getBookId());
				
		be.setBookName(book.getBookName());
		
		return book;
	}
	@Override
	public Book deleteBook(Integer id) {
		BookEntity be = entityManager.find(BookEntity.class, id);
				
		
		Book book = new Book();
		book.setBookName(be.getBookName());
		book.setBookId(be.getBookId());
		
		entityManager.remove(be);
		
		return book;
	}
}
