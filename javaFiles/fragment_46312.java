@RequestMapping("/{id}/**")
public void doSomething(@PathVariable("id") int id, HttpServletRequest request) {
String remainingUrl = (String) request.getAttribute(
    HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
...
}