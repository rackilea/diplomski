Scanner input;
        String myFileName = "......";
        try {
            input = new Scanner(new File(myFileName)); 
            double sum = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] vals = line.split("\\s+");
                sum += Double.parseDouble(vals[3]);
            }
            System.out.println("sum = " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }