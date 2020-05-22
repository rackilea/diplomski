Gson gson = new Gson();

String data = "[{\"author\":\"Jonathan Khatz\", \"id\":8,"
    + "\"name\":\"Criptography  6\","
    + "\"publisher\":\"Chapman\", \"year\":2010},"
    + "{\"author\":\"Hausi Muller\", \"id\":9,"
    + "\"name\":\"SelfAdaptiveSystem\","
    + "\"publisher\":\"UVic\", \"year\":2010}]";

Book[] books = gson.fromJson(data, Book[].class);
Arrays.asList(books).forEach(System.out::println);