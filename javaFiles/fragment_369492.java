public static Result aboutAMan() {
    DynamicForm df = form().bindFromRequest();

    int age;
    String name;
    boolean isAdmin;

    name = (df.get("name") != null) ? df.get("name") : "The Unknown";
    age = (df.get("age") != null) ? Integer.parseInt(df.get("age")) : 0;
    isAdmin = Boolean.parseBoolean(df.get("is_admin"));

    String about = (name + " is " + age + " years old and " + ((isAdmin) ? "is" : "isn't") + " an admin");

    return ok(about);
}