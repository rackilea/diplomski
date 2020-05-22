String url = httpRequest.getRequestURL().toString();
if (Pattern.matches(this.excludePattern, url)) {
   chain.doFilter(request, response);
   LOGGER.fine("Excluded URL requested");
   return;
}