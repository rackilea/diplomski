public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        CarLoader carLoader = context.getBean(CarLoader.class);
        for (Car car : carLoader.getCars()) {
            System.out.println("CAR - " + car.getName());
        }
    }

}