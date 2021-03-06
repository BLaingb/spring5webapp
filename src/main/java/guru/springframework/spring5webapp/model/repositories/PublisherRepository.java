package guru.springframework.spring5webapp.model.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.model.Publisher;

/**
 * PublisherRepository
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long>{

    
}