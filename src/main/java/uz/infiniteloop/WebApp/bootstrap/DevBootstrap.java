package uz.infiniteloop.WebApp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import uz.infiniteloop.WebApp.model.Author;
import uz.infiniteloop.WebApp.model.Book;
import uz.infiniteloop.WebApp.model.Publisher;
import uz.infiniteloop.WebApp.repositories.AuthorRepository;
import uz.infiniteloop.WebApp.repositories.BookRepository;
import uz.infiniteloop.WebApp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private  void initData() {
        Publisher kamalak = new Publisher("Kamalak Nashriyoti", "Hamid Olimjon 4-48");

        publisherRepository.save(kamalak);
        Author ibrokhim = new Author("Ibrokhimjon", "Saydakhmatov");
        Book ddd = new Book("Domain Driven Design", "1234", kamalak);
        ddd.getAuthors().add(ibrokhim);
        authorRepository.save(ibrokhim);
        bookRepository.save(ddd);

        Author akmal = new Author("Akmal", "Bositxonov");
        Publisher yoshlar = new Publisher("Yoshlar Nashriyoti", "Amir Temur ko'chasi 55");

        publisherRepository.save(yoshlar);
        Book noEJB = new Book("J2EE Development without EJB", "23444", yoshlar);
        akmal.getBooks().add(noEJB);
        authorRepository.save(akmal);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
