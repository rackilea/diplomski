class FooBar {
    static int foo = Init.initFoo(new HashMap<String, String>() {{
                        put("key1", "value1");
                        put("key2", "value2");
                     }});
}