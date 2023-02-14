package com.api.book.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.service.BookService;

@RestController /*
				 * by giving an @RestController annotation you will get the same result as you put @ResponceBody
				 * Annotation. you can leave @ResponceBody annotation by using @RestController ,
				 * by doing this you will get the same result ....
				 */

/* If you want to make API you must use @RestController Annotation... */
public class BookControllers {
	
	
	@Autowired //it will automatically autowire BookService... 
	private BookService bookService; 
	
	
	
	
	//@RequestMapping(value="/books", method=RequestMethod.GET )
	//@ResponseBody     //if we want to send as it is String given below to print in views.....
	@GetMapping("/books") 
	public List<Book> getBooks()
	{
		Book book = new Book();
		return this.bookService.getAllBooks();
	}

	//to get a single book...
//	@RequestMapping(value="/books / {id}" , method = RequestMethod.GET)
//	public Book getBook(@PathVariable("id") int id)
//	{
//		
//		return  this.bookservice.getBookById(id);
//	}
	
	
	@GetMapping(" /books/{id}")
	public Book getBook(@PathVariable ("id") int id)
	{
		
		return bookService.getBookById(id);
	}
	//######Solution on get book by id#####										//getbyId problem solved .....
//	@GetMapping("/books/{id}")
//	public ResponseEntity<Book> getBook(@PathVariable (value="id") int id)
//	{
//		Book book = bookService.getBookById(id);
//		if(book==null)
//		{
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.of(Optional.of(book));
//	}
	

	
	
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book b =this.bookService.addBook(book);
		return b;
	}
	@DeleteMapping("/books/{bookid}")
	public void deleteBook(@PathVariable ("bookid") int bookid)
	{
		this.bookService.deleteBook(bookid);
	}

	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book , @PathVariable  ("bookId") int bookId)
	{
		this.bookService.updatebook(book,bookId);
		return book; 
	}
}





