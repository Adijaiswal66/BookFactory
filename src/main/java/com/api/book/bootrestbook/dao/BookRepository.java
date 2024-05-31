package com.api.book.bootrestbook.dao;

import com.api.book.bootrestbook.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends CrudRepository <Book, Integer> {
    public Book findById(int id);
//    public Book save(Book book);


}
