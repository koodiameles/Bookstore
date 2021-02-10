package fi.jussi.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.jussi.Bookstore.domain.Book;
import fi.jussi.Bookstore.domain.BookRepository;
import fi.jussi.Bookstore.domain.Category;
import fi.jussi.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository ) {
		return (args) -> {
			
			//Tallenna muutama testikirja tietokantaan
			crepository.save(new Category("Romaanit"));
			crepository.save(new Category("Tieteiskirjat"));
			crepository.save(new Category("Satukirjat"));
			
			Book testbook1 = new Book("Kirja1", "Kirjailija1", "123123", 13.50, 1991, crepository.findByName("Romaanit").get(0));
			Book testbook2 = new Book("Kirja2", "Kirjailija2", "456123", 120.50, 1901, crepository.findByName("Romaanit").get(0));
			Book testbook3 = new Book("Kirja3", "Kirjailija3", "789123", 19.50, 2000, crepository.findByName("Romaanit").get(0));
			brepository.save(testbook1);
			brepository.save(testbook2);
			brepository.save(testbook3);
		};
	}

}
