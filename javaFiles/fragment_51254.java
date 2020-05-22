package webapp

import groovy.util.logging.Slf4j
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Slf4j
//@CompileStatic
@Controller("/book")
class BookController implements BooksApi {

    final BookService bookService

    BookController(BookService bookService) {
        this.bookService = bookService
    }

    @Get("/list")
    List<Book> listBooks() {
        return bookService.findAll()
    }

    @Get("/count")
    int Count() {
        return bookService.count()
    }

    @Override
    @Get("/{id}")
    Book show(Long id) {
        return bookService.find(id)
    }

    @Delete("/{id}")
    Book delete(Long id) {
        return bookService.delete(id)
    }

    @Post("/save")
    def save(@Body Object JSON) {
        String bookid = JSON?.bookid
        String name = JSON?.name
        def b = bookService.save(bookid, name)
        return HttpResponse.created(b)
    }

    @Get("/")
    String index() {
        return "Book Service"
    }
}