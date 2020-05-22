String[] stringArray = {"google", "char", "char2", "0", "12", "zoombi", "integer"};
    for (int i = 0; i < stringArray.length - 1; i++) {
        for(int j=i+1; j<stringArray.length;j++)
              if (stringArray[j].length() < stringArray[i].length()) {
                 String temp = stringArray[i];
                 stringArray[i] = stringArray[j];
                 stringArray[j]= temp;
             }
    }

    System.out.println(Arrays.toString(stringArray));