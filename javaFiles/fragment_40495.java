public static Object[] lazyHtmlEscape(final String... args) {
     return Arrays.stream(args)
                  .map(arg -> new Object {
                      @Override
                      public String toString() {
                          // here argument will be escaped only if
                          // toString method will be called
                          // (that happens if loglevel is enabled)
                          return HtmlUtil.htmlEscape(e);
                      }
                  })
                  .toArray();
}