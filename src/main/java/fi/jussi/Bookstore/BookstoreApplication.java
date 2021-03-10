package fi.jussi.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.jussi.Bookstore.domain.AppUser;
import fi.jussi.Bookstore.domain.AppUserRepository;
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
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, AppUserRepository urepository ) {
		return (args) -> {
			
			//Tallenna muutama testikirja tietokantaan
			crepository.save(new Category("Romaanit"));
			crepository.save(new Category("Tieteiskirjat"));
			crepository.save(new Category("Satukirjat"));
			
			Book testbook1 = new Book("Kirja1", "Kirjailija1", "123123", 13.50, 1991, crepository.findByName("Romaanit").get(0));
			Book testbook2 = new Book("Kirja2", "Kirjailija2", "456123", 120.50, 1901, crepository.findByName("Romaanit").get(0));
			Book testbook3 = new Book("Kirja3", "Kirjailija2", "789123", 19.50, 2000, crepository.findByName("Romaanit").get(0));
			brepository.save(testbook1);
			brepository.save(testbook2);
			brepository.save(testbook3);

			// Luo käyttäjät: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}

}
