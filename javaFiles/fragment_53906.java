protected Status handleTransaction() {
    Map<String, String> context = new HashMap<>();
    context.put("id", "someText");
    try {
        return handleContext(context);
    } finally{
        context.remove("id");
    }
}
protected Status handleContext(Map<String, String> context) {
    //some other method calls
}