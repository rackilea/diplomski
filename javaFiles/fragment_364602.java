@RequestMapping("/addBook")
@ResponseBody
public String addBook(@RequestParam("name") String name) {
    Book book = new Book();
    book.setContent(name);
    repo.save(book);
    return name;        
}