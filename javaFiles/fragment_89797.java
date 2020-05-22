public class Test {
    String name;
    String surname;
    int age;
    int height;
    long id;

    public Test(JSONObject jsonObject) {
        this.name = jsonObject.getString("name");
        this.surname = jsonObject.getString("surname");
        this.age = jsonObject.getInt("age");
        this.height = jsonObject.getInt("height");
        this.id = jsonObject.getLong("id");
    }
}