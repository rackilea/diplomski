static class PersonData {
    int age;
    String surname;
    public String toString() {
        return "[age = " + age + ", surname = " + surname + "]";
    }
}

public static void main(String[] args) {
    String json = "{\"Thomas\": {\"age\": 32,\"surname\": \"Scott\"},\"Andy\": {\"age\": 25,\"surname\": \"Miller\"}}";
    System.out.println(json);
    Gson gson = new Gson();
    Map<String, PersonData> decoded = gson.fromJson(json, new TypeToken<Map<String, PersonData>>(){}.getType());
    System.out.println(decoded);
}