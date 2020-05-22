public static void main(String[] args) {
        String fileName= "study_panel.csv";
        File file= new File(fileName);

        // 2-dimensional list of strings
        List<List<String>> lines = new ArrayList<>();
        List<String> header = null; //Lets store the header in a seperate list
        Map<Integer, List<String>> recombinationM = new HashMap<>();
        Map<Integer, List<String>> noRecombinationM = new HashMap<>();

        Scanner inputStream;
        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");

                if (header == null){
                    header= Arrays.asList(values);
                    continue;//go to the next line as header is read
                }
                // Adds the currently parsed line to the 2-dimensional string list
                lines.add(Arrays.asList(values));
            }
            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Iterate through the 2-dimensional data and store column headers


        for (int i=0; i<lines.size(); i++) {
            List<String> recombinationHdr = new ArrayList<>();
            List<String> noRecombinationHdr = new ArrayList<>();
            for (int j=0; j<lines.get(i).size()-1; j++) {
                //Comparison
                if (lines.get(i).get(j).equals(lines.get(i).get(j + 1))) {
                    System.out.println("No recombination");
                    noRecombinationHdr.add(header.get(j));//To store the current header
                    //hdrs.add(header.get(j+1)); // To store the next header
                } else {
                    System.out.println("Recombination");
                    recombinationHdr.add(header.get(j));//To store the current header
                    //recombinationHdr.add(header.get(j+1)); // To store the next header
                }
            }
            recombinationM.put(i, recombinationHdr);
            noRecombinationM.put(i, noRecombinationHdr);
        }
        //Print maps
        System.out.println("== No Recombination ==");
        for (Map.Entry<Integer,List<String>> entry : noRecombinationM.entrySet()){
           System.out.println("Line: " + entry.getKey() + " - " + entry.getValue().toString());
        }

        System.out.println("== Recombination ==");
        for (Map.Entry<Integer,List<String>> entry : recombinationM.entrySet()){
           System.out.println("Line: " + entry.getKey() + " - " + entry.getValue());
        }
    }