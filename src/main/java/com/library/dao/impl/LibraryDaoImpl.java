package com.library.dao.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.library.dao.LibraryDao;
import com.library.model.Book;

@Repository
public class LibraryDaoImpl extends JdbcDaoSupport implements LibraryDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertBook(Book bk) {
		String sql = "insert into library VALUES (?, ?, ?, ?,?,?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				bk.getBook_id(),bk.getBook_name(),bk.getAuthor(),bk.getEdition(),0,0,0,0
		});
	}
	
	@Override
	public List<Map<String, Object>> getDate(Book bk) {
		int day1,month1,year1;
		String sql = "select day,month,year from library where book_id='"+bk.getBook_id()+"'";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
//		System.out.println(rows);
//		List<Book> result = new ArrayList<Book>();
//		for(Map<String, Object> row:rows){
//			day1=(int) row.get("day");
//			month1=(int) row.get("month");
//			year1=(int) row.get("year");
//
//			System.out.println(day1 + month1 + year1);
//		}
		return rows;
	}
	
	@Override
	public List<Map<String, Object>> getAvailable(Book bk) {
		String sql = "select issued_to from library where book_name='"+bk.getBook_name()+"'";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
//		System.out.println(rows);
//		List<Book> result = new ArrayList<Book>();
//		for(Map<String, Object> row:rows){
//			day1=(int) row.get("day");
//			month1=(int) row.get("month");
//			year1=(int) row.get("year");
//
//			System.out.println(day1 + month1 + year1);
//		}
		return rows;
	}


	@Override
	public void deleteBook(Book bk) {
		// TODO Auto-generated method stub
		String sql = "delete from library where book_id = ?" ;
		getJdbcTemplate().update(sql, new Object[]{
				bk.getBook_id()
		});
		
		
	}

	@Override
	public void issueBook(Book bk) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update("update library set issued_to = ?, day = ? ,month = ?,year = ? where book_id = ?",
				new Object[] {bk.getIssued_to(),bk.getDay(),bk.getMonth(),bk.getYear(),bk.getBook_id()});
		
	}

	@Override
	public void returnBook(Book bk) {
		// TODO Auto-generated method stub
		int day,month,year;
		Date date=new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		year=localDate.getYear();
		month=localDate.getMonthValue();
		day = localDate.getDayOfMonth();
		int day1=day,month1=month,year1=year;
		String sql = "SELECT * FROM library where book_id=\""+bk.getBook_id()+"\"";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Book> result = new ArrayList<Book>();
		for(Map<String, Object> row:rows){
			day1=(int) row.get("day");
			month1=(int) row.get("month");
			year1=(int) row.get("year");
		}
		int fine=(year1-year)*365+(month1-month)*30+(day1-day)*1;
		
		getJdbcTemplate().update("update library set issued_to = ?,day = ?,month = ?,year = ? where book_id = ?",
				new Object[] {0,0,0,0,bk.getBook_id()});
		
	}

}