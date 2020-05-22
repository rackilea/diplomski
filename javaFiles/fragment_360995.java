private static void selectionSort(int[] list, int low, int high) { 
        if (low < high) { 
          int posMax = high; 
          int theMax = list[high]; 
          for (int i = 0; i < high; i++) { 
            if (list[i] > theMax) { 
              theMax = list[i]; 
              posMax = i; 
            }// if 
          }// for 
        list[posMax] = list[high]; 
        list[high] = theMax; 
        selectionSort(list, low, high - 1); 
        }// if 
    }