package Harjoitustyo.BookStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	
	@NotBlank(message = "Enter Title")
	private String title;
	
	@NotBlank(message = "Enter Author")
	private String author;
	
	@NotBlank(message = "Enter ISBN")
	private String isbn;
	
	@Min(value = 1500, message = "Are you sure your book is that old?")
	@Max(value = 2022, message = "Your book cannot be published in the future.")
	private int publicationYear;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	
	public Book() {
		super();
	}

	public Book(String title, String author, String isbn, int publicationYear, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.price = price;
		this.category = category;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publicationYear="
				+ publicationYear + ", price=" + price + ", category=" + category + ", getId()=" + getId()
				+ ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor() + ", getIsbn()=" + getIsbn()
				+ ", getPublicationYear()=" + getPublicationYear() + ", getPrice()=" + getPrice() + ", getCategory()="
				+ getCategory() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	}





	