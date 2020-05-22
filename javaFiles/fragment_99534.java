protected static String renderTemplate(String templateName, Map<String,Object> args) {
    try {
        Template template = TemplateLoader.load(template(templateName));
        // Get the template into a String
        return template.render(args);
    } catch (TemplateNotFoundException ex) {
        if (ex.isSourceAvailable()) {
            throw ex;
        }
        StackTraceElement element = PlayException.getInterestingStrackTraceElement(ex);
        if (element != null) {
            throw new TemplateNotFoundException(templateName, Play.classes.getApplicationClass(element.getClassName()), element.getLineNumber());
        } else {
            throw ex;
        }
    }