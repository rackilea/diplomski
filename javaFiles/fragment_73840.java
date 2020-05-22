public class PodamDataGenerator {
    public static void main(String[] args) {

        PodamFactory podamFactory = new PodamFactoryImpl();
        //Limit number of elements to collections fields
        podamFactory.getStrategy().setDefaultNumberOfCollectionElements(2);
        Student student = podamFactory.manufacturePojo(Student.class);
        System.out.println("Podam Pojo\n-----------\n " + student);
    }
}