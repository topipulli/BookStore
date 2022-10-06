package Harjoitustyo.BookStore.web;

import java.util.List;
import java.util.Optional;

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
import Harjoitustyo.BookStore.domain.CategoryRepository;



@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
		@RequestMapping("/booklist")
		public String index(Model model) {
			model.addAttribute("books", repository.findAll());
			return "booklist";
		}
		
	    @RequestMapping(value="/books", method = RequestMethod.GET)
	    public @ResponseBody List<Book> bookListRest() {	
	        return (List<Book>) repository.findAll();
	    }    

	    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {	
	    	return repository.findById(id);
	    } 
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long bookId, Model model){ 
		repository.deleteById(bookId);
		 return "redirect:../booklist";
		}
		
		@RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			model.addAttribute("categories", crepository.findAll());
			return "addbook";
		}
		
		@RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.GET})
		public String save(Book book) {
			repository.save(book);
			 return "redirect:booklist";

		}
			
		}
		
		
	


