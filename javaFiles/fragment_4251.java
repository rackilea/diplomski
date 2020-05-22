ObjectMapper mapper = new ObjectMapper();

Foo foo = mapper.readValue(
        "{ \"some_key\": \"{\\\"a\\\": 1, \\\"b\\\": \\\"text\\\"}\" }",
        Foo.class);

System.out.println(foo.getSome_key());