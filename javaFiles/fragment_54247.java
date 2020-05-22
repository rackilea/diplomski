private String removeParameter(String string, final String parameterName) {
    List<String> list = newArrayList(string.split("&"));

    Collection<String> filtered = Collections2.filter(list, new Predicate<String>() {
        public boolean apply(String s) {
            return !s.startsWith(parameterName + "=");
        }
    });

    return Joiner.on("&").join(filtered);
}