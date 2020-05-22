public static void main(String[] args) {
        Object animal = new Animal("Elephant");
        classType(animal);
    }

    private static void classType(Object type) {
        if (type instanceof Animal) {
            System.out.println("Matched  " + type);
        } else {
            System.out.println("Unmatched  " + type);
        }
    }