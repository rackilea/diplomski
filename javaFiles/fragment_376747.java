List<String> options = new ArrayList<>();
options.add("One");
options.add("Two");
if (Util.isWindows()) {
    options.add("Three");
}
context.setVariable("authenticationOptions", options.toArray(new String[0]));