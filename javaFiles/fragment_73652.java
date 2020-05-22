interface Processor {
    public JsonNode process(JsonNode input);
}

Class A {
    public JsonNode create() {...}
}

Class B implements Processor {
    public JsonNode process(JsonNode input) {
        // logics
        return output;
    }
}

Class C implements Processor {
    public JsonNode process(JsonNode input) {
        // logics
        return output;
    }
}