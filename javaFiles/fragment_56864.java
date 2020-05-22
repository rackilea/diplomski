private AntPathMatcher antPathMatcher = new AntPathMatcher();

@GetMapping("/show/**")
public ... image(HttpServletRequest request) {
    String uri = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    String pattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
    String path = antPathMatcher.extractPathWithinPattern(pattern, uri);

    ...
}