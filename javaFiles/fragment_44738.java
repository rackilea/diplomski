String filename = "input.txt";
        File file = new File(filename);         
        Scanner sc = new Scanner(file);

        List<List<String>> myArray = new ArrayList<>();

        while(sc.hasNextLine()) {
             String line = sc.nextLine();  // each line will have an equation
             String[] equations = line.split("\\s+");

             List<String> lineArray = new ArrayList<>();
             for (String s : equations) {
                 s = s.trim();
                 lineArray.add(s);
             }                              
             myArray.add(lineArray);
        }

        sc.close();