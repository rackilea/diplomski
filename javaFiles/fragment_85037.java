@ModelAttribute
public void validateModel(HttpServletRequest) {
  Map<String, String> requestAttributes = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
  if (requestAttributes.containsKey("model") {
    String model = requestAttributes.get("model");
    if (!carService.isSupportedModel(model)) throw new RuntimeException("This model is not supprted by this application.");
  }
}