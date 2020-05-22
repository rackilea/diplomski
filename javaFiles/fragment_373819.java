@RequestMapping("/add")
public String userPage(Model model) {

    model.addAttribute("register", new RegisterForm());

    LOGGER.debug("Accessed userAdd page!");

    return "index/cadastro";
}