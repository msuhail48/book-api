package com.jsp.Library.Service;

import java.util.List;

import com.jsp.Library.Model.Book;

public interface BookService {

	long save(Book book);

	Book get(long id);

	List<Book> list();

	void update(long id, Book book);

	void delete(long id);

}
