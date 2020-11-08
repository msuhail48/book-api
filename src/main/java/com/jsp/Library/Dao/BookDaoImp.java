package com.jsp.Library.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.jsp.Library.Model.Book;

@Repository
public class BookDaoImp implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	public long save(Book book) {
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	public Book get(long id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	public List<Book> list() {
		List<Book> list = sessionFactory.getCurrentSession().createQuery("from Book").list();
		return list;
	}

	public void update(long id, Book book) {
		Session session = sessionFactory.getCurrentSession();
		Book book2 = session.byId(Book.class).load(id);
		book2.setTitle(book.getTitle());
		book2.setAuthor(book.getAuthor());
		session.flush();
	}

	public void delete(long id) {
		Book book = sessionFactory.getCurrentSession().byId(Book.class).load(id);
		sessionFactory.getCurrentSession().delete(book);
	}

}
