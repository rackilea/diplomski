Gson gson = new Gson();
try {
    Object o = gson.fromJson(json, Object.class);
    System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(o));
} catch (Exception e) {
    System.out.println("invalid json format");
}