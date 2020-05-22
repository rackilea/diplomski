shodanJsonObject.entrySet()
        .stream()
        .map(Entry::getValue)
        .filter(JsonElement::isJsonArray)
        .map(JsonElement::getAsJsonArray)
        .flatMap(jsonElements -> StreamSupport.stream(jsonElements.spliterator(), false))
        .peek(System.out::println)
        .map(JsonElement::getAsJsonObject)
        .map(jsonObject -> jsonObject.getAsJsonObject("location"))
        .filter(location -> location.getAsJsonPrimitive("country_code").getAsString().equals("US"))
        .forEach(jsonObject -> {
        }); // forEach is a terminal operation and it "pushes" the entire chain above