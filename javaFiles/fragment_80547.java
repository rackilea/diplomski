try {
    Class<?> c = Class.forName(args[0]);
    Object t = c.newInstance();

    Method[] allMethods = c.getDeclaredMethods();
    for (Method m : allMethods) {
        String mname = m.getName();
        if (!mname.equals("main")) {
            System.out.println("involking" + mname);
            Object o = m.invoke(t, args[1]);
            System.out.println("return value " + o.toString());
        }
    }
}  catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (InstantiationException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IllegalAccessException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IllegalArgumentException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}