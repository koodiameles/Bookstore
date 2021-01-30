package fi.jussi.Bookstore.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fi.jussi.Bookstore.domain.Book;


@Controller
public class BookController {

	ArrayList<Book> booklist = new ArrayList<>();

	@GetMapping("/index")
	public String getindex (Model model) {					
		System.out.println("GET index ");
		return "index";
	}

	@PostMapping("/index") 
	public String postindex (Model model) {	
		System.out.println("POST index ");
		return "index";													
	}
	
}
