package fi.jussi.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {

}
