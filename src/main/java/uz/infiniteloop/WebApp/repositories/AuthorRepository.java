package uz.infiniteloop.WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import uz.infiniteloop.WebApp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
