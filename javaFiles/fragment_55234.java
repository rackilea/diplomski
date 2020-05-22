// Get your template as a String from the DB
  String template = getTemplateFromDatabase();
  Map<String, Object> model = getModel();

  Configuration cfg = new Configuration();
  cfg.setObjectWrapper(new DefaultObjectWrapper());

  Template t = new Template("templateName", new StringReader(template), cfg);

  Writer out = new StringWriter();
  t.process(model, out);

  String transformedTemplate = out.toString();