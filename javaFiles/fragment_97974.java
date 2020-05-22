class JsonRoot {
    Map<String, JsonName> test;
}

class JsonName {
    String number;
    String color;
    Map<String, Integer> cars;
}

...
JsonRoot jsonRoot;
Gson gson = new Gson();
try (BufferedReader reader = Files.newBufferedReader(Paths.get("test.json"))) {
    jsonRoot = gson.fromJson(reader, JsonRoot.class);
}