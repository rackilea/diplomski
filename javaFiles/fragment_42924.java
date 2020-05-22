public static <T> T readFromInput(String message, Class<T> c) throws Exception{
    System.out.println(message);
    Scanner scanner = new Scanner(System.in);
    try {
        if(c == Integer.class)
            // the next cast to Integer is safe
            return c.cast(Integer.valueOf(scanner.nextInt()));
        if(c == String.class)
            // the next cast to String is safe
            return c.cast(scanner.nextLine());
        if(c == Double.class)
            // the next cast to Double is safe
            return c.cast(Double.valueOf(scanner.nextDouble()));
        if(c == Float.class)
            // the next cast to Float is safe
            return c.cast(Float.valueOf(scanner.nextFloat()));
    } catch (InputMismatchException e) {
        throw new Exception(e);
    }
    return null;
}