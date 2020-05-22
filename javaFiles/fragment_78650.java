public class CreateBookParameters {
    private UUID authorId;
    private int pages;
    private BookRating rating;
    private MultipartFile file;
    private MultipartFile file2;

    // add getters & setters for each
}

@RequestMapping(value = "/", method = RequestMethod.POST)
public ResponseEntity createBook(CreateBookParameters p) {
  // ...
}