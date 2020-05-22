public static Result index() {

    Map<String, String> labels = new HashMap<String, String>();

    labels.put("first", "First label");
    labels.put("second", "Second label");
    // etc etc
    labels.put("hundredth", "Label no. 100");

    return ok(template.render(labels));
}