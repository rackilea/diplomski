public static void doSomething(Object arg) {

    if (arg instanceof Object[]) {
        Object[] list = (Object[]) arg;
        for (Object item : list) {
            System.out.println(item);
        }
    }

   }