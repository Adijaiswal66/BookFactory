package com.api.book.bootrestbook.Services;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
     public List<Book> getAllBooks(){
      List<Book> list = (List<Book>) this.bookRepository.findAll();
      return list;
     }
     public Book getBookById(int id){
         Book book=null;
         try{
              book = this.bookRepository.findById(id);
             return book;
         } catch (Exception e){
             e.printStackTrace();
         }
         return book;
     }
     public Book addBook(Book b){
        Book result =  this.bookRepository.save(b);
          return result;
     }

     public String deleteBook(int id){
        this.bookRepository.deleteById(id);
        return "Book has been deleted with ID:" + id;
     }
     public String updateBook(int id,Book book){
         book.setId(id);
         this.bookRepository.save(book);
         return "Book has been updated with ID:" + id;

     }


}
