package uz.infiniteloop.WebApp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import uz.infiniteloop.WebApp.model.Author;
import uz.infiniteloop.WebApp.model.Book;
import uz.infiniteloop.WebApp.repositories.AuthorRepository;
import uz.infiniteloop.WebApp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private  void initData() {
        Author ibrokhim = new Author("Ibrokhimjon", "Saydakhmatov");
        Book ddd = new Book("Domain Driven Design", "1234");
        ddd.getAuthors().add(ibrokhim);
        authorRepository.save(ibrokhim);
        bookRepository.save(ddd);

        Author akmal = new Author("Akmal", "Bositxonov");
        Book noEJB = new Book("J2EE Development without EJB", "23444");
        akmal.getBooks().add(noEJB);
        authorRepository.save(akmal);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
