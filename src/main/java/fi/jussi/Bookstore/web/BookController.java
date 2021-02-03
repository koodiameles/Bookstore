package fi.jussi.Bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.jussi.Bookstore.domain.Book;
import fi.jussi.Bookstore.domain.BookRepository;


@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	//MAIN PAGE
	@GetMapping("/index")
	public String getindex (Model model) {					
		System.out.println("GET index ");
		return "index";
	}
	
	//SHOW BOOKLIST
	@GetMapping("/booklist")
	public String booklist (Model model) {					
		System.out.println("GET booklist ");
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	//ADD BOOK
	@GetMapping("/add")
	public String addBook (Model model) {					
		System.out.println("Add book ");
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	//EDIT BOOK
	@GetMapping("/edit/{id}")
	public String editBook (@PathVariable("id") Long bookId, Model model) {					
		System.out.println("Edit book ");
		model.addAttribute("book", repository.findById(bookId));
		return "editbook";
	}
		
	
	//DELETE BOOK
	@GetMapping("/delete/{id}")
	public String deleteBook (@PathVariable("id") Long bookId, Model model) {					
		System.out.println("Delete book " + bookId);
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
   
	

	@PostMapping("/index") 
	public String postindex (Model model) {	
		System.out.println("POST index ");
		return "index";													
	}
	
	//SAVE BOOK
	@PostMapping("/save")
	public String saveBook (Book book) {					
		System.out.println("Save book ");
		repository.save(book);
		return "redirect:booklist";
	}
	
}
