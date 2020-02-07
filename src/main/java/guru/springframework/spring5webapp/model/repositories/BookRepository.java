package guru.springframework.spring5webapp.model.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.spring5webapp.model.Book;

/**
 * BookRepository
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    
}