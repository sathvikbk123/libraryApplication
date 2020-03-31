package com.library.controllers;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.model.Book;

import com.library.service.LibraryService;

@Controller
public class LibraryController {

	@Autowired
	LibraryService libraryService;

    //the welcome page
	@RequestMapping(value="/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

    //show the add student form and also pass an empty backing bean object to store the form field values
	@RequestMapping(value = "/addNewBook", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addBook", "bk1", new Book());
	}


    //Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/addNewBook", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("bk1") Book bk) {
		libraryService.insertBook(bk);
		ModelAndView model = new ModelAndView("successful");
		//model.addObject("students", students);
		return model;
	}

    //delete books saved in database
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public ModelAndView show1() {
		ModelAndView model = new ModelAndView("deleteBook", "bk2", new Book());
//		libraryService.deleteBook(bk);
//		ModelAndView model = new ModelAndView("successful");
		return model;
	}
	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public ModelAndView processDelete(@ModelAttribute("bk2") Book bk) {
		libraryService.deleteBook(bk);
		ModelAndView model = new ModelAndView("successful");
		//model.addObject("students", students);
		return model;
	}
	
	//Issue a book
		
		@RequestMapping(value = "/issueBook", method = RequestMethod.GET)
		public ModelAndView show3() {
			return new ModelAndView("issueBook", "bk3", new Book());
			

	}
		@RequestMapping(value = "/issueBook", method = RequestMethod.POST)
		public ModelAndView processUpdate(@ModelAttribute("bk3") Book bk) {
			int day,month,year;
			Date date=new Date();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			year=localDate.getYear();
			month=localDate.getMonthValue();
			day = localDate.getDayOfMonth();
			bk.setDay(day);
			bk.setMonth(month);
			bk.setYear(year);
			libraryService.issueBook(bk);
			ModelAndView model = new ModelAndView("successful");
			return model;
		}
		
	//return a book and also display the fine 
	@RequestMapping(value="/returnBook",method = RequestMethod.GET)
	public ModelAndView show4() {
		return new ModelAndView("returnBook", "bk4", new Book());
		
	}
	@RequestMapping(value = "/returnBook", method = RequestMethod.POST)
	public ModelAndView processReturn(@ModelAttribute("bk4") Book bk) {
		int fine=0;
		int day1=0,month1=0,year1=0;
		int day=0,month=0,year=0;		
		List<Map<String, Object>> rows =libraryService.getDate(bk);
		for(Map<String, Object> row:rows){
			day1=(int) row.get("day");
			month1=(int) row.get("month");
			year1=(int) row.get("year");
		}
		Date date=new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		year=localDate.getYear();
		month=localDate.getMonthValue();
		day = localDate.getDayOfMonth();
//		}
//		catch(Exception e) {e.printStackTrace();}
		
		fine=(year-year1)*365+(month-month1)*30+(day-day1)*1;
		libraryService.returnBook(bk);
		ModelAndView model = new ModelAndView("returnBook1");
		model.addObject("fine", fine);
		return model;
	}
	
	//Search for a given book
	@RequestMapping(value="/findBook",method = RequestMethod.GET)
	public ModelAndView show5() {
		return new ModelAndView("findBook", "bk5", new Book());
		
	}
	@RequestMapping(value = "/findBook", method = RequestMethod.POST)
	public ModelAndView processFind(@ModelAttribute("bk5") Book bk) {
//		Connection con=null;
		int isAvailableCount = 0,isNotAvailableCount=0;
		
		List<Map<String, Object>> rows =libraryService.getAvailable(bk);
		for(Map<String, Object> row:rows){
			String temp = row.get("issued_to").toString();
			if(temp.equals("0")) {
				isAvailableCount++;
			}else {
				isNotAvailableCount++;
			}
		}
		ModelAndView model = new ModelAndView("findBook1");
		int totalCount = isAvailableCount + isNotAvailableCount;
		model.addObject("isAvailableCount", isAvailableCount);
		model.addObject("totalCount", totalCount);
		return model;
	}
	

}