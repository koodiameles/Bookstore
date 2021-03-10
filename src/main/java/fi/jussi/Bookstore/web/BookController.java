package fi.jussi.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.jussi.Bookstore.domain.Book;
import fi.jussi.Bookstore.domain.BookRepository;
import fi.jussi.Bookstore.domain.CategoryRepository;


@Controller
public class BookController {

	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;

	//MAIN PAGE
	@GetMapping(value={"/index", "/"})
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
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	//EDIT BOOK (VAIN ADMIN)
	@GetMapping("/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editBook (@PathVariable("id") Long bookId, Model model) {			
		System.out.println("Edit book ");
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}

	//DELETE BOOK (VAIN ADMIN)
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
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
