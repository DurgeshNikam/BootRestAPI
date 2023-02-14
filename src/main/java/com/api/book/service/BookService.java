package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.book.entities.Book;
@Component
public class BookService {
	/*
	 * Those service are interacting with dao layer means dao layer calling methods
	 * of database layer.so, basically book services are calling methods of databses
	 * layer.But here we don't want to make Database so make fake service here
	 * only...
	 */		
	
		private static List<Book> list = new ArrayList<>();
	/* we will store data in static block */
		static {
			list.add(new Book(1,"Complete java Reference", "xyz"));
			list.add(new Book(2,"Head First To JAVA", "abc"));
			list.add(new Book(3,"Think in java", "pqr"));
			list.add(new Book(4,"Think in pyhton", "ddd"));
		}
	 
		//get all books (to get all books , we have to create new "getAllBooks()" method )
		public List<Book> getAllBooks()
		{
			return list;
		}
	 
		// To get single book (to get a single book, we have to create a new "getBookById()"method)
//		public Book getBookById(int id)
//		{
//			Book book = null;
//			list.forEach(e->{System.out.println(e);});
//			
			//list.stream().filter(e->e.getId()==id).findFirst().get();
//			findFirst=Returns : an Optional describing the first element of this stream,or an empty Optional if the stream is empty.
			//stream=Returns : a sequential Stream over the elements in this collection.
			
//			return book;
	//	}
		
		
		
		
		public Book getBookById(int id)
		{
			Book book=null;
			book=list.stream().filter(e->e.getId()==id).findFirst().get();
			return book;
		}
		
		
		public Book addBook(Book b)
		{
			list.add(b);
			return b;
		}
		
		public void deleteBook(int bid)
		{
			list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
			
		}

		public void updatebook(Book book, int bookId) {
			list = list.stream().map(b->{
				if(b.getId()==bookId) {
					b.setTitle(book.getTitle());
					b.setAuthor(book.getAuthor());
				}return b;
			}).collect(Collectors.toList());
			
		}
		
}




