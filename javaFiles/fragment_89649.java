PrintWriter out = null;
    try {
        out = new PrintWriter("med.txt");
        System.out.println("Name of the medication:");
        String medName = console.readLine();

        System.out.println("The Dosage of the medication:");
        Double medDose = console.readDouble();

        System.out.println("Time of day to take");
        String dayTime = console.readLine();
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        if(out != null) {
            out.close();
        }
    }