public static void main(String[] args) {
        int size;
        int tineminte = 0;
        Scanner input = new Scanner(System.in);
        System.out
                .println("Input number of bits:");
        size = input.nextInt();

        int counter = 0;
        Vector<Integer> A = new Vector<Integer>();
        System.out.println("Input First number in binary");
        while (counter < size) {
            A.add(counter, input.nextInt());
            counter++;
        }
        System.out.println("First number in binary (output):");
        for (counter = 0; counter < size; counter++)
            System.out.println(A.elementAt(counter));

        counter = 0;

        Vector<Integer> B = new Vector<Integer>();
        System.out.println("Input second number in binary:");
        while (counter < size) {
            B.add(counter, input.nextInt());
            counter++;

        }

        System.out.println("Second number in binary (output):");
        for (counter = 0; counter < size; counter++)
            System.out.println(B.elementAt(counter));

        Vector<Integer> C = new Vector<Integer>();

        counter = size - 1;

        while (counter != -1) {
            if (A.elementAt(counter) == 1 && B.elementAt(counter) == 0) {
                if (tineminte == 1)
                    C.add(0);

                else
                    C.add(1);

                counter--;
            } else if (A.elementAt(counter) == 0 && B.elementAt(counter) == 1) {
                if (tineminte == 1) {
                    C.add(0);
                } else
                    C.add(1);

                counter--;
            } else if (A.elementAt(counter) == 0 && B.elementAt(counter) == 0)

            {
                if (tineminte == 1) {
                    tineminte = 0;
                    C.add(1);
                } else
                    C.add(0);

                counter--;
            } else if (A.elementAt(counter) == 1 && B.elementAt(counter) == 1) {

                if (tineminte == 1) {
                    C.add(1);

                } else

                    C.add(0);

                tineminte = 1;

                counter--;
            }

        }
        // You forgot the last bit
             if (tineminte==1)
            C.add(1);
        System.out.println("Suma:");
        for(int i=C.size()-1;i>=0;i--) {
            System.out.println(C.elementAt(i));
        }

    }