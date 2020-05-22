values = new HashMap<>();
    values.put(Pet.class, new Pet());
    values.put(Car.class, new Car());

    System.out.println("get(Pet.class).getClass() = " + get(Pet.class).getClass());
    System.out.println("get(Car.class).getClass() = " + get(Car.class).getClass());