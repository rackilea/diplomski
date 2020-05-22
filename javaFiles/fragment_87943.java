static void sortAlphabetical() { 
        String tempName;
        int [] intSwap; //<-- note I changed this as an int[] array
        boolean flag = false;
        while (flag==false) {
          flag = true;
          for (int i = 0; i < studentNamesArray.length-1; i++) { //<-- note I changed this to length - 1 to avoid IndexOutOfBoundsException
            if (studentNamesArray[i].compareTo(studentNamesArray[i + 1])>0) {
              tempName = studentNamesArray[i];
              studentNamesArray[i] = studentNamesArray[i + 1];
              studentNamesArray[i + 1] = tempName;

              intSwap = studentMarksArray[i];
              studentMarksArray[i] = studentMarksArray[i+1];
              studentMarksArray[i+1]= intSwap;
              flag = false;
            }
          }
        }
      }