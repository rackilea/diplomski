public static void main(String[] args) {
        Object animal = new Animal("Elephant");
        classType(animal.getClass());
    }

    private static <T> void classType(Class<T> tClass) {
        if (tClass.getName().equals("Animal")) {
            System.out.println("Matched  " + tClass.getName());
        } else {
            System.out.println("Unmatched  " + tClass.getName());
        }
    }