class User {

    private static int uid = 0;

    private String name;
    private int id;

    public User(String name) {
       this.id = uid++;
       this.name = name;
    }

    // getters
}