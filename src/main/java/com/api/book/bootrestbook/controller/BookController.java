package com.api.book.bootrestbook.controller;

import com.api.book.bootrestbook.Services.BookService;
import com.api.book.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
          @GetMapping("/books")
          public ResponseEntity<List<Book>> getBooks(){
              List<Book> list = this.bookService.getAllBooks();
                 if (list.size()<=0){
                     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                 }else {
                     return ResponseEntity.status(HttpStatus.CREATED).body(list);
                 }
          }
          @GetMapping("/books/{id}")
          public ResponseEntity<Book> getBook(@PathVariable("id") int id){
           try{
                 Book book = this.bookService.getBookById(id);
                 return ResponseEntity.of(Optional.of(book));
             }catch (Exception e){
                 return   ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
             }
          }
          @PostMapping("/books")
          public ResponseEntity<Book> addBook(@RequestBody Book book){
              Book b = null;

              try{
                      b=this.bookService.addBook(book);
                      return ResponseEntity.of(Optional.of(b));
                  }
                  catch (Exception e){
                      e.printStackTrace();
                      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                  }
              }


          @DeleteMapping("/books/{id}")
          public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
              try{
                  this.bookService.deleteBook(id);
                  return ResponseEntity.status(HttpStatus.OK).build();
              }
              catch (Exception e){
                  e.printStackTrace();
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
              }
          }
          @PutMapping("books/{id}")
          public ResponseEntity<Book> updateBook(@PathVariable("id") int id,@RequestBody Book book){
              try{
                  this.bookService.updateBook(id,book);
                  return ResponseEntity.ok().body(book);
              }
              catch (Exception e){
                  e.printStackTrace();
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
              }

          }
}
