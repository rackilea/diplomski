@Autowired
SpringTemplateEngine templateEngine;

public File exportToPdfBox(Map<String, Object> variables, String templatePath, String out) {
    try (OutputStream os = new FileOutputStream(out);) {
        // There are more options on the builder than shown below.
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(getHtmlString(variables, templatePath), "file:");
        builder.toStream(os);
        builder.run();
    } catch (Exception e) {
        logger.error("Exception while generating pdf : {}", e);
    }
    return new File(out);
}

private String getHtmlString(Map<String, Object> variables, String templatePath) {
    try {
        final Context ctx = new Context();
        ctx.setVariables(variables);
        return templateEngine.process(templatePath, ctx);
    } catch (Exception e) {
        logger.error("Exception while getting html string from template engine : {}", e);
        return null;
    }
}