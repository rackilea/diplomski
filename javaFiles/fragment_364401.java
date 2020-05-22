@Autowired
    InternalRenderer internalRenderer;

    @RequestMapping(value = "/internalRender")
    public void internalRender(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) throws Exception {

        String evalView = internalRenderer.evalView(request, response, model, locale, "index");

        logger.debug("evalView: " + evalView);

        //TODO: use the generated code to create the pdf and return it

    }