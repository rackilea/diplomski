class Cow implements Animal {
    public void says(String msg) {
        System.out.printf("%s, I mean moo!%n", msg);
    }
}

class Sheep implements Animal {
    public void says(String msg) {
        System.out.printf("%s, I mean baah!%n", msg);
    }
}