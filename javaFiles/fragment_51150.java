public class CustomHandlerMapping extends AbstractUrlHandlerMapping {
    @Override
    protected Object lookupHandler(String urlPath, HttpServletRequest request) {
        final List<String> patterns = urlDecider.getPatterns();
        final PathMatcher pathMatcher = getPathMatcher();
        final boolean anyMatch = patterns.stream()
            .anyMatch(pattern -> pathMatcher.match(pattern, urlPath));
        return anyMatch ? someController : null;
    }
}