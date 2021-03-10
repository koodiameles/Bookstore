package fi.jussi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.jussi.Bookstore.domain.Book;
import fi.jussi.Bookstore.domain.BookRepository;
import fi.jussi.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Test
	public void findByAuthorBookShouldReturnListOfBooks() {
		List<Book> books = bookRepository.findByAuthor("Kirjailija1");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Kirja1");
	}

	@Test
	public void findByAuthorShouldReturnSize() {
		List<Book> books = bookRepository.findByAuthor("Kirjailija2");
		//Tuottaa virheen, sillä kirjailijan2 kirjoja on vain 2 eikä 3.
		assertThat(books).hasSize(3);
		
	}
	
	@Test 
	public void deleteBook() {
		 
		List<Book> books = bookRepository.findByTitle("Kirja3");
		bookRepository.deleteById(books.get(0).getId());
		books= bookRepository.findByTitle("Kirja3");
		assertThat(books).hasSize(0);
	}


	@Test
	public void insertNewBook() {
        Book book = new Book("Kirja1", "Kirjailija1", "123123", 13.50, 1991, categoryRepository.findByName("Romaanit").get(0));
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}