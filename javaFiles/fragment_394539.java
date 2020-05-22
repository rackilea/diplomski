public static void selectionSort(int[] data) {
      int temp;
      int j;
      int i;
      for (i = 0; i < data.length - 1; i++ ){  
          int min = i; 
          for(j = i + 1; j < data.length; j++){   
            if(data[j] < data[min])         
               min = j;
          }
          temp = data[min];   
          data[min] = data[i];
          data[i] = temp; 

       }
     }
public static void main(String[] args) {
         int[] bigdata;

                   for(int i = 100; i < 200000; i *= 2){ 
                      // Here you double the size of bigdata array
                      bigdata = new int[i];
                      // You fill the i sized array
                      randomFill(bigdata, 100000);
                      display(bigdata);
                      System.out.println("Is sorted before selectionSort: " + isSorted(bigdata));
                      long start = System.currentTimeMillis();
                      selectionSort(bigdata);
                      display(bigdata);
                      long elapsed = System.currentTimeMillis() - start;
                      System.out.println("Is sorted after selectionSort: " + isSorted(bigdata));
                      System.out.println("Elapsed time in milliseconds " + elapsed);
          }
       }