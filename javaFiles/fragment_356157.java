import java.util.Random;

    public class MyList {
        private int[] list = null;

        public MyList(int numInts) {
            list = new int[numInts];
        }

        public void fillWithRandom() {
            Random r = new Random();
            for (int i=0; i < list.length; i++)
                list[i] = r.nextInt();
        }

        public void print() {
            for (int i=0 ; i < list.length; i++)
                System.out.println(list[i]);
        }
    }