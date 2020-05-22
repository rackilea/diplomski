package webapp

import grails.gorm.services.Service

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Service(Book)
interface BookService {
    int count()

    Book save(@NotBlank String bookid, @NotBlank String name)

    List<Book> findAll()

    Book find(@NotNull Long id)

    Book delete(@NotNull Long id)    
}