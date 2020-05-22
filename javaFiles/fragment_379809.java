@RequestMapping("/{id}/**")
public void foo(@PathVariable("id") int id, HttpServletRequest request) {
    String restOfTheUrl = (String) request.getAttribute(
        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    ...
}