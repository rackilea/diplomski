public void sortedArrayByRowTot() {
      //Creates tempArray2 to copy salaryArray into
      int [][] tempArray2 = new int [salaryArray.length][salaryArray[0].length];

      //Copies salaryArray into tempArray2
      for (int i = 0; i < salaryArray.length; i++) {
        for (int j = 0; j < salaryArray[i].length; j++) {
          tempArray2[i][j] = salaryArray[i][j];
        }
      }

      //Creates rowSum array to store sum of each row
      int [] rowSums = new int [tempArray2.length];
      for (int i = 0; i < tempArray2.length; i++) {
        for (int j = 0; j < tempArray2[0].length; j++) {
          rowSums[i] += tempArray2[i][j];
        }
      }

      //Modified Bubble Sort of rowSum array (highest to lowest values)
      int temp;
      int i = 0;
      for(int j = rowSums.length; j > 0; j--){
        boolean isSwap = false;
        for (i = 1; i < j; i++) {
          if(rowSums[i-1] < rowSums[i]) {
            temp = rowSums[i-1];
            rowSums[i-1] = rowSums[i];
            rowSums[i] = temp;
            isSwap = true;
            //swaps rows in corresponding tempArray2 
            int [] temp2 = tempArray2[i-1];
            tempArray2[i-1] = tempArray2[i];
            tempArray2[i] = temp2;
          }
        }

        if(!isSwap){
          break;
        }
      }  

      //Prints sorted array 
      System.out.println("Sorted array: ");
      for (i = 0; i < tempArray2.length; i++) {
        for (int j = 0; j < tempArray2[i].length; j++) {
          System.out.print("$"+ tempArray2[i][j] + " ");
        }
        System.out.println();
      }
    }