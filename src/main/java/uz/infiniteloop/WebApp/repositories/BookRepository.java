package uz.infiniteloop.WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import uz.infiniteloop.WebApp.model.Book;

public interface BookRepository  extends CrudRepository<Book, Long> {
}
