public static int [] inputGrades(){
    System.out.print("\nInput test scores, enter -1 when you're finished.\n");
    Scanner kb = new Scanner (System.in);
    int [] iGrades = new int [10];
    for (int i =0; i<iGrades.length;i++){
      iGrades[i] = Integer.MIN_VALUE;
    }
    for (int i =0; i<iGrades.length;i++){
        iGrades[i]=kb.nextInt();
        if (iGrades[i] ==-1)
           break;
    }
    kb.close(); // Don't forget to close the scanner
    return iGrades;   
}


public static int countArrayElements(int[] array){
        int iCount = 0;
        for (int i = 0; i < array.length; i ++)
        {   
          if(array[i] > -1){           
              iCount++;
          }
        }
        System.out.print ("\nThere are " + iCount + " numbers in the array.");
        return iCount;
}