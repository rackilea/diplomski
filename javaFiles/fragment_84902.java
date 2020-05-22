//arr being your old array

    ArrayList<String> list = new ArrayList<String>();

    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {  
            list.add(arr[i][j]); 
        }
    }

    // now you need to add it to new array


    String[] newArray = new String[list.size()];
    for (int i = 0; i < newArray.length; i++) {
        newArray[i] = list.get(i);
    }