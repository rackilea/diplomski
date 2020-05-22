public class ArticleController {

    // inject the spring validator.
    @Autowired
    private LocalValidatorFactoryBean validator;

    @RequestMapping(value = "/edit", method = PUT)
    public String doEdit(@ModelAttribute("article") final Article article,
            final BindingResult bindingResult) {
        // generates article's tag, not editable by user
        article.setTag(generateTag(article));
        // validate
        validator.validate(article, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/edit";
        } else {
            service.save(article);
            return "redirect:/list";
        }
    }
}