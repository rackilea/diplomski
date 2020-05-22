Map<String, String> map = Collections.unmodifiableMap(
    //since it's an anonymous class, it cannot infer the
    //types from the content
    new HashMap<String, String>() {{
        put.("hello", "world");
    }})
    );