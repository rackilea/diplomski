import java.util.Arrays;

    class Test {


        public static void main(String[] args) {

            // array & copy both refer to the same Object
            double[] array = {5,4,3,2,1};
            double[] copy = array;
            // the following array is filled up "by hand" - thus it has no reference to the previous object
            double[] store = new double[array.length];



            for (int i = 0; i < array.length ; i++) {
                store[i] = array[i];
            }


            Arrays.sort(array);


            System.out.println("array"); // 1,2,3,4,5
            for (double d: array)
                System.out.println(d);
            System.out.println("copy"); // 1,2,3,4,5
            for (double d: copy)
                System.out.println(d);
            System.out.println("store"); // 5,4,3,2,1
            for (double d: store)
                System.out.println(d);


            // Primitives show a different behaviour
            double a = 5;
            double b = a;
            System.out.println(a +  " / " + b); // 5 / 5
            a = 10;
            System.out.println(a +  " / " + b); // 10 / 5
        }

    }