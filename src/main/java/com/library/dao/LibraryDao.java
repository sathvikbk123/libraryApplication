package com.library.dao;


import java.util.List;
import java.util.Map;

import com.library.model.Book;

public interface LibraryDao {
	void insertBook(Book bk);
	void deleteBook(Book bk);
	void issueBook(Book bk);
	void returnBook(Book bk);
	List<Map<String, Object>> getDate(Book bk);
	List<Map<String, Object>> getAvailable(Book bk);
}