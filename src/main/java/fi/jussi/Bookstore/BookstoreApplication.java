package fi.jussi.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.jussi.Bookstore.domain.Book;
import fi.jussi.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			
			//Tallenna muutama testikirja tietokantaan
			Book testbook1 = new Book("Kirja1", "Kirjailija1", "123123", 13.50, 1991);
			Book testbook2 = new Book("Kirja2", "Kirjailija2", "456123", 120.50, 1901);
			Book testbook3 = new Book("Kirja3", "Kirjailija3", "789123", 19.50, 2000);
			repository.save(testbook1);
			repository.save(testbook2);
			repository.save(testbook3);
		};
	}

}
