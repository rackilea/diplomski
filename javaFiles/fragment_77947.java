public class Test {
        Company company = new Company();

        public static void main(String[] args) {
            Test test = new Test();
            test.start();
        }

    private void start() {

    System.out.println("IT work");
    company.addTrainTo(new Train("One"));
    System.out.println("End first add");
    company.addTrainTo(new Train("two"));
    System.out.println("End second add\n");

    System.out.println("Follow example will not work");
    company = new Company();
    company.addTrainTo(new Train("One"));
    System.out.println("End first add");
    company = new Company(); // <--- create the ERROR
    company.addTrainTo(new Train("two"));
    System.out.println("End second add");
    }
}