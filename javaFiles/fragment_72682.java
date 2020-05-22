String[] purposeAll= {"P1","P2"};
    //String[] purposeAll= {"P3","P1"}; Testing Stuff.

    String[][] purpose = { 
    { "P1", "a", "b", "c", "d", "e", "f", "h" },
    { "P2", "a", "b", "c", "d", "e", "g", "i" },
    { "P3", "l", "m", "n", "o", "p", "q" } };

    List<String[]> arrayOfPurposes = new ArrayList<>();
    //Looping through the purposeAll to check purpose's first 
    //entry and seeing if it equals the first purposeAll value
    for(int i = 0; i < purpose.length; i++){
        for(int j = 0; j < purposeAll.length; j++){
            if(purpose[i][0].equals(purposeAll[j])){
                arrayOfPurposes.add(purpose[i]);
            }
        }
    }

    //One way to get the results into a String[][]
    String[][] result = {arrayOfPurposes.get(0),arrayOfPurposes.get(1)};

    //Displaying to console
    for(int i = 0; i < result.length; i++){
        for(int j = 0; j < result[i].length; j++){
            System.out.print(result[i][j]);
        }
        System.out.println();
    }