public static void main(String[] args)  {
        SingletonObject object = SingletonObject.getInstance();

        System.out.println("Object was instantiated: " + object.getInstantiationCounter() + " times.");

        object = SingletonObject.getInstance();

        System.out.println("Object was instantiated: " + object.getInstantiationCounter() + " times.");

        object = SingletonObject.getInstance();

        System.out.println("Object was instantiated: " + object.getInstantiationCounter() + " times.");

    }