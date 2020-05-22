public enum Food {
    PASTA("Pasta", 1),
    PIZZA("Pizza", 2);


    /** state variables */
    private String name;
    private int id;

    /** Constructor */
    Food(String name, int id) {
        this.name=name;
        this.id=id;
    }


    /** Accessors */
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}