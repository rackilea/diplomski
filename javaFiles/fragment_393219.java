Class<?> cInt = Integer.TYPE;

    Long l = new Long(123);

    System.out.println(cInt.isInstance(l)); // false
    System.out.println(cInt.isAssignableFrom(cInt)); // true