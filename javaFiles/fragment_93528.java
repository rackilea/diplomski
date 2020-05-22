public void hackCar(TestCar other) {

        Field f = other.getDeclaredField("doorUnlockCode");  /*here we create the object of the desired field*/

        f.setAccessible(true);  //here, we set its access to true

        System.out.println(f.get(obj));   /*here, we use the field object to get its value*/

        Field f1 = other.getDeclaredField("hasAirCondition");

        f1.setAccessible(true);

        System.out.println(f1.get(obj));

        Field f2 = other.getDeclaredField("brand");

        f2.setAccessible(true);

        System.out.println(f2.get(obj));

        System.out.println(other.licensePlate);  /*this can be accessed directly since the access specifier for the field is "public"*/
    }