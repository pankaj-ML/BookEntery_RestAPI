package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.Book;

public interface BookRepo extends MongoRepository<Book, Integer> {

}
