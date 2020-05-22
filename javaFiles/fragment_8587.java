package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepositoryextends ContactRepository<Contact, Long> {
    List<Customer> findByLastName(String lastName);
}