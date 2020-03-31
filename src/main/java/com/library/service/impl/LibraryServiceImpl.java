package com.library.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.LibraryDao;
import com.library.model.Book;
import com.library.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	LibraryDao libraryDao;

	@Override
	public void insertBook(Book bk) {
		libraryDao.insertBook(bk);
	}
	@Override
	public void deleteBook(Book bk) {
		// TODO Auto-generated method stub
		libraryDao.deleteBook(bk);
	}
	
	@Override
	public void returnBook(Book bk) {
		// TODO Auto-generated method stub
		libraryDao.returnBook(bk);
		
	}
	@Override
	public void issueBook(Book bk) {
		// TODO Auto-generated method stub
		libraryDao.issueBook(bk);
		
	}
	@Override
	public List<Map<String, Object>> getDate(Book bk) {
		// TODO Auto-generated method stub
		return libraryDao.getDate(bk);
		
	}
	
	@Override
	public List<Map<String, Object>> getAvailable(Book bk) {
		// TODO Auto-generated method stub
		return libraryDao.getAvailable(bk);
		
	}
}