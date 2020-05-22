public String myMethod() {
    SBBuilder builder = new SBBuilder()
        .add("Hello").add("there")
        .add("it", "works", "just", "fine!");

    for (int i = 0; i < 10; i++) {
        builder.add("adding").add(String.valueOf(i));
    }

    System.out.println(builder.build());
}

public static class SBBuilder {
    private StringBuilder sb = new StringBuilder();

    public SBBuilder add(String... parts) {
        for (String p : parts) {
            sb.append(p).append(' '); // char is even faster here! ;)
        }
        return this;
    }

    public String build() {
        return sb.toString();
    }
}