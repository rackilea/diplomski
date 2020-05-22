public static void main(String[] args) {

        A a = new A();
        a.setCommon(1);
        a.setForGSON1(2);
        a.setForGSON12(12);
        a.setForGSON3(3);
        a.setForGSON2(2);

        Gson gsonStrategy1 = new GsonBuilder().setExclusionStrategies(new Strategy1()).create();
        Gson gsonStrategy2 = new GsonBuilder().setExclusionStrategies(new Strategy2()).create();
        Gson gsonStrategy3 = new GsonBuilder().setExclusionStrategies(new Strategy3()).create();

        System.out.println(gsonStrategy1.toJson(a));
        System.out.println(gsonStrategy2.toJson(a));
        System.out.println(gsonStrategy3.toJson(a));
    }