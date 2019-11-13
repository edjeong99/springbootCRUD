package com.infy.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.model.Book;
import com.infy.service.BooksServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("bookAPI")
public class BooksAPI {
	static Logger logger = LogManager.getLogger(BooksAPI.class);
	@Autowired
	Environment environment;
	@Autowired
	BooksServiceImpl serviceImpl;
	@RequestMapping(value="books",method=RequestMethod.GET)
	public ResponseEntity<List<Book>> getAllBooks() {
		logger.trace("<C> BooksAPI <M> getAllBooks");
		List<Book> books=new ArrayList<Book>();
		try {
			//BooksServiceImpl serviceImpl = (BooksServiceImpl) ContextFactory.getContext().getBean("BooksServiceImpl");
			books=serviceImpl.getAllBooks();
			return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
		} catch (Exception e) {
		//	Environment environment = ContextFactory.getContext().getEnvironment();
			Book book = new Book();
			book.setMessage(environment.getProperty(e.getMessage()));
			books.add(book);
			return new ResponseEntity<>(books,HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		return new ResponseEntity<Book>(serviceImpl.addBook(book), HttpStatus.OK);
	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateBook(@RequestBody Book book){
		return new ResponseEntity<Book>(serviceImpl.updateBook(book), HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> addBook(@PathVariable Integer id){
		return new ResponseEntity<Book>(serviceImpl.deleteBook(id), HttpStatus.OK);
	}
	
}
