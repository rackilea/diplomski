@RequestMapping("/v1/**")
public void foo(HttpServletRequest request) {
    String fullPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    String subPath = StringUtils.removeStart(fullPath, "/v1");
    ...
}