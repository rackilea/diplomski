public static void main(String[] args) throws Exception {

        System.out.println("Default locale: " + Locale.getDefault());
        int count = 0;
        double sum = 0.0;
        FileWriter fout = new FileWriter("test.txt");

        // Character used for the decimal point is '.'
        fout.write("2 3.4 5 6 7.4 9.1 10.5 done");
        fout.close();
        FileReader fin = new FileReader("test.txt");
        Scanner src = new Scanner(fin);

        // Setting locale of Scanner
        System.out.println("Scanner locale before resetting to Locale.US: " + src.locale());
        src.useLocale(Locale.US);
        System.out.println("Scanner locale after resetting: " + src.locale());

        // Read and sum numbers.
        while (src.hasNext()) {
            if (src.hasNextDouble()) {
                sum += src.nextDouble();
                count++;
            } else {
                String str = src.next();
                if (str.equals("done"))
                    break;
                else {
                    System.out.println("File format error.");
                }
            }
        }
        src.close();
        System.out.println("Average is " + sum / count);

    }