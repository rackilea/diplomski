public static void main(String[] args) throws Exception {
    System.out.println(calc("cos", Math.PI));
    System.out.println(calc("sin", Math.PI /2));
}

public static double calc(String fx, double arg) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    return (Double) Math.class.getMethod(fx, double.class).invoke(null, arg);
}