public class Test {
    public static void main(String[] args) {
        Method[] methods = CarService.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            for (Class<?> type : method.getParameterTypes()) {
                System.out.printf("- %s%n", type.getName());
            }
        }
    }
}