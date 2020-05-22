void printMiddleofArray(String[] arrayOfNames) {
    if (arrayOfNames.length %2 ==0)
                {
                  System.out.println(arrayOfNames[arrayOfNames.length /2]);
                  System.out.println(arrayOfNames[(arrayOfNames.length /2)-1]);
                } else {
                  System.out.println(arrayOfNames[(arrayOfNames.length /2)-1]);
                }
}