public static void _extends(Map<?, ?> args, Closure body, PrintWriter out, ExecutableTemplate template, int fromLine) {
    try {
        if (!args.containsKey("arg") || args.get("arg") == null) {
            throw new TemplateExecutionException(template.template, fromLine, "Specify a template name", new TagInternalException("Specify a template name"));
        }
        String name = args.get("arg").toString();
        if (name.startsWith("./")) {
            String ct = BaseTemplate.currentTemplate.get().name;
            if (ct.matches("^/lib/[^/]+/app/views/.*")) {
                ct = ct.substring(ct.indexOf("/", 5));
            }
            ct = ct.substring(0, ct.lastIndexOf("/"));
            name = ct + name.substring(1);
        }
        BaseTemplate.layout.set((BaseTemplate) TemplateLoader.load(name));
    } catch (TemplateNotFoundException e) {
        throw new TemplateNotFoundException(e.getPath(), template.template, fromLine);
    }
}