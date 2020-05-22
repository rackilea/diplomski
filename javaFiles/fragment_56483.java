@RequestMapping(value = "/{webpageId}/**", method = RequestMethod.GET)
public String contentWebpageById(HttpServletRequest request) {

    String pattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);  

    String extractedPathParam = pathMatcher.extractPathWithinPattern(pattern, request.getServletPath());
    extractedPathParam = extractedPathParam.replace("http:/", "http://");
    extractedPathParam = extractedPathParam.replace("https:/", "https://");
    //do whatever you want with parsed string..
}