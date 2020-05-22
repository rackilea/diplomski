public static void main(String[] args) {
    Map<String, String> data = new HashMap<>();
    data.put("activate.message.success", "success");
    data.put("activate.title", "Good Title");
    data.put("activate.message.error", "error");
    data.put("activate.message.short.poll", "This is short poll");

    JSONObject json = build(data);
    System.out.println(json.toString(4));
}