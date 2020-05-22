int[] Array1 = new int[] {1,652,5,15,385,4,55,666,13};
    int[] Array2 = new int[] {2,4658,9,55,-588,10,1083,17};
    boolean contains = false;
    List<Integer> results = new ArrayList<Integer>();


    for(int i=0; i<Array1.length; i++) {
        for(int j=0; j<Array2.length; j++) {
            if(Array1[i]==Array2[j]) {
                contains = true;
                break;
            }
        }
        if(!contains) {
            results.add(Array1[i]);
        }
        else{
            contains = false;
        }
    }

    System.out.println(results);