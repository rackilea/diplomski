class Pojo {

    private User user = new User();
    private Food food = new Food();
    private House house = new House();

    // getters, setters, toString
}

class User {

    @Unit("m")
    private int height = 10;

    // getters, setters, toString
}

class Food {

    @Unit("C")
    private int temperature = 50;

    // getters, setters, toString
}

class House {

    @Unit("m")
    private int width = 10;

    // getters, setters, toString
}