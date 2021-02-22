package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private  final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pub=new Publisher();
        pub.setAddressLine1("Haana ch yum bgan");
        pub.setCity("Murun");
        pub.setZip("11000");
        pub.setName("Buma");
        publisherRepository.save(pub);

        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Domain driver Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(pub);
        pub.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub);

        Author rod=new Author("Rod","Jonhson");
        Book noEJB=new Book("J2EE Development without EJB","45768990593423");
        rod.getBooks().add(noEJB);
        noEJB.setPublisher(pub);
        noEJB.getAuthors().add(rod);
        pub.getBooks().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub);



        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: "+bookRepository.count());
        System.out.println("Number of publishers Book: "+pub.getBooks().size());


    }
}
