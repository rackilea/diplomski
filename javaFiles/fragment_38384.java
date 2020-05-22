public Map<String, String> handleRequest(Map<String, Object> input, Context context) {

    String brs = "42";
    String rsm = "123";

    Map<String, String> output = new HashMap<>();
    output.put("brs", brs);
    output.put("rsm", rsm);

    return output;
}