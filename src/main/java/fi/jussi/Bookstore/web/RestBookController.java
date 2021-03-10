package fi.jussi.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.jussi.Bookstore.domain.Book;
import fi.jussi.Bookstore.domain.BookRepository;
import fi.jussi.Bookstore.domain.CategoryRepository;

@RestController
public class RestBookController {

    @Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
    
    // RESTful service to get all book
    @RequestMapping(value="/kirjat", method = RequestMethod.GET)
    public List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }    

	// RESTful service to get book by id
    @RequestMapping(value="/kirja/{id}", method = RequestMethod.GET)
    public Optional<Book> findbookRest(@PathVariable("id") Long id) {	
    	return repository.findById(id);
    }       

}
