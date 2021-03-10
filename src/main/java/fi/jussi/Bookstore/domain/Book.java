package fi.jussi.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title, author, isbn;
	private double price;
	private int year;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	
	//konstruktorit
	public Book(String title, String author, String isbn, double price, int year, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.year = year;
		this.category = category;
	}

	public Book() {
		super();
	}

	//set ja get -metodit
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", category=" + category + ", id=" + id + ", isbn=" + isbn + ", price="
				+ price + ", title=" + title + ", year=" + year + "]";
	}

}
