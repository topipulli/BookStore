package Harjoitustyo.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Harjoitustyo.BookStore.domain.Book;
import Harjoitustyo.BookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book test1 = new Book("testikirja1", "Meika Makarooni", "AEIOUYÄÖ00890", 1993, 60.63);
			Book test2 = new Book("testikirja2", "Meika Makarooni", "AEIOUYÄÖ0089990", 1993, 60.62);
			Book test3 = new Book("testikirja3", "Meika Makarooni", "AEIOUYÄÖ008990", 1993, 60.63);

			repository.save(test1);
			repository.save(test2);
			repository.save(test3);

	};
	}
	}
