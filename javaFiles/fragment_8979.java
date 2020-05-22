Scanner reader = new Scanner(new File("./data.txt"));

    double[] grades = new double[6];
    String[] names = new String[6];
    String s = reader.nextLine();
    String[] split = s.split(" ");

    int sum= 0;
    int counter= 0;
    int avg= 0;
        for (int i = 0; i < grades.length; i++) {
            grades[i] = Double.valueOf(split[0]);
            names[i]= split[1];
            sum+=grades[i];
            counter++;
            avg= sum/counter;            
            System.out.println(avg);
        }