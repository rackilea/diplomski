public static void main(String[] args) {

    GsonFactory factory= new GsonFactory();

    DateTest dt = new DateTest(new Date());
    String j1 = factory.toString(dt);
    System.out.println(j1);
    DateTest dt2 = factory.fromString(j1, DateTest.class);
    System.out.println(dt2);

}