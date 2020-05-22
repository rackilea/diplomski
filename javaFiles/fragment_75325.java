String str = "{ \"id\": 1, \"data\": { \"a\": 1 } }";
try {
    System.out.println(new ObjectMapper().readValue(str,Employee.class));
} catch (IOException e) {
    e.printStackTrace();
}