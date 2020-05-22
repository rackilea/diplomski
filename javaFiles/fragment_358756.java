test("");
test("{}");
test("{ \"foo\": 42 }");
test("{\n" +
     "  \"foo\": 42\n" +
     "}\n" +
     "{\n" +
     "  \"bar\": 666\n" +
     "}");
test(Files.readString(Paths.get("test.json")));