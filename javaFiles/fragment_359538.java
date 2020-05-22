@RequestMapping("/users/{register}")
public String createForm(@PathVariable("register") String register, Model model) {
    // here "register" will have value "something".
    model.addAttribute("user", new Customer());
    return "user/register";
}