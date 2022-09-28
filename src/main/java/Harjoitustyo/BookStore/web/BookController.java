package Harjoitustyo.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Harjoitustyo.BookStore.domain.Book;
import Harjoitustyo.BookStore.domain.BookRepository;



@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
		@RequestMapping("/booklist")
		public String index(Model model) {
			model.addAttribute("books", repository.findAll());
			return "booklist";
		}
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long bookId, Model model){ 
		repository.deleteById(bookId);
		 return "redirect:../booklist";
		}
		
		@RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			return "addbook";
		}
		
		@RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.GET})
		public String save(Book book) {
			repository.save(book);
			 return "redirect:booklist";

		}
			
		}
		
		
	


