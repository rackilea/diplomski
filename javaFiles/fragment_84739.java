private static final VAR_USER = "user"

    @Autowired
    private SpringTemplateEngine templateEngine;

    ...

    public void method(User user,...) {
        Map<String, Object> variables;
        variables.put(VAR_USER, user);

        context.setVariables(variables);
        org.thymeleaf.context.Context context = new Context(locale);

        String evaluated = templateEngine.process("myTemplate", context);
    }