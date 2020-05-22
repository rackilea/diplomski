import java.util.StringTokenizer;


public class Class1 {

        public Class1() {}

        private class BigObject {
                byte _myArr[];
                public BigObject() {
                        _myArr = new byte[10000000];
                }
        }
    public static void main(String[] args) {
                (new Class1()).perform(Integer.parseInt(args[0]));
        }
        public void perform(int numOfObjects) {
                System.out.println("creating 10 MB arrays.");
                BigObject arr[]  = new BigObject[numOfObjects];
                for (int i=0;i <numOfObjects; i++) {
                        System.out.println("about to create object "+i);
                        arr[i] = new BigObject();
                        System.out.println("object "+i+" created");
                }
                System.out.println("sleeping for 5 seconds.");
                try {
                Thread.sleep(5000);
                }catch (Exception e) {e.printStackTrace();}
                System.out.println("Done.");
    }

}