package Harjoitustyo.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Harjoitustyo.BookStore.domain.Book;
import Harjoitustyo.BookStore.domain.BookRepository;
import Harjoitustyo.BookStore.domain.Category;
import Harjoitustyo.BookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("SCI-FI"));
			crepository.save(new Category("ROMANCE"));
			crepository.save(new Category("CRIME"));
			crepository.save(new Category("SCIENCE"));
			
			repository.save(new Book("testikirjaCAT", "Meikä Mandoliini", "8383938393", 1929, 60.60, crepository.findByName("CRIME").get(0)));
			repository.save(new Book("testikirjaCAT2", "Meikä Makarooni", "8383938393B", 1929, 60.69, crepository.findByName("SCI-FI").get(0)));


	};
	}
	}
