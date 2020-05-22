public FreeMarkerProcessor(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext, freemarker.template.Configuration freemarkerConfiguration) {
  this.freemarkerConfiguration = freemarkerConfiguration;
  requestContext = new RequestContext(request, response, servletContext, new HashMap<>());
}

public void processTemplate(Template template, Map<String, Object> model, Writer writer) throws TemplateException, IOException {
  requestContext.getModel().clear();
  requestContext.getModel().putAll(model);
  model.put(AbstractTemplateView.SPRING_MACRO_REQUEST_CONTEXT_ATTRIBUTE, requestContext);
  template.process(model, writer);
}