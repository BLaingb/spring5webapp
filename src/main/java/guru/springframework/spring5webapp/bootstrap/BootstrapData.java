package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.model.repositories.AuthorRepository;
import guru.springframework.spring5webapp.model.repositories.BookRepository;
import guru.springframework.spring5webapp.model.repositories.PublisherRepository;

/**
 * BootstrapData
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;
    private final PublisherRepository publisherRepo;

    public BootstrapData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book domainDrivenDesign = new Book("Domain Driven Design", "123");
        Publisher pub = new Publisher("Pub1", "Roncopollo #4", "Queretaro", "Querétaro", "76160");
        eric.getBooks().add(domainDrivenDesign);
        domainDrivenDesign.getAuthors().add(eric);

        publisherRepo.save(pub);
        authorRepo.save(eric);
        bookRepo.save(domainDrivenDesign);

        domainDrivenDesign.setPublisher(pub);
        pub.getBooks().add(domainDrivenDesign);
        publisherRepo.save(pub);
        authorRepo.save(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123141");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub);
        pub.getBooks().add(noEJB);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
        publisherRepo.save(pub);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepo.count());
        System.out.println("Number of publishers: " + publisherRepo.count());
    }
    
}