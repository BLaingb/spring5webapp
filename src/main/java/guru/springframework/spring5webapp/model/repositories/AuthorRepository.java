package guru.springframework.spring5webapp.model.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.spring5webapp.model.Author;

/**
 * AuthorRepository
 */
public interface AuthorRepository extends CrudRepository<Author, Long>{

    
}