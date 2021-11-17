package com.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.model.Book;
import com.mongo.repository.BookRepo;

@RestController
public class BookController {
	
	@Autowired
	private BookRepo repository;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		
		repository.save(book);
		return "Book Saved! : " +book;
	}
	
	@PostMapping("/addAll")
	public String saveAll(@RequestBody List<Book> book) {
		repository.saveAll(book);
		return  "All book Saved" + book ;
	}
	
	
	@GetMapping("/findAll")
	public List<Book> getBooks(){
		return repository.findAll();
	}
	
	@GetMapping("/findBy/{id}")
	public Optional<Book> getBook(@PathVariable int id){
		
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Book Deleted" +id;
	}
	
	@DeleteMapping("/deleteAll")
	public String deletAll() {
		repository.deleteAll();
		return "All Book Deleted";
	}
}
