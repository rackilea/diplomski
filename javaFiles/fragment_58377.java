@Controller
class MyController {

    @GetMapping("/view")
    public String view(Model model) {
        try {
            model.addAttribute("actualData", mayThrowExceptionDataFetch());
        } catch(Exception e) {
            model.addAttribute("errorData", e.getMessage());
        }
        return "view";
    }

    private String mayThrowExceptionDataFetch() {
        // Either return a value or throw an exception
    }
}