@RequestMapping("/book/**")
@Controller
public class BookController {

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String create(
        @ModelAttribute("bookCommand") final BookCommand bookCommand) {

        Book book = createBookFromBookCommand(bookCommand);
        return "redirect:/book/" + book.getId();
    }

    @RequestMapping(value = "/book/form", method = RequestMethod.GET)
    public String createForm(final ModelMap modelMap) {
        modelMap.addAttribute("all", "what you need");
        return "book/create"; //book/create.jsp
    }
}