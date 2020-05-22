int maxValues[] = new int [5];
    int array[] = new int [50];
    for (int i = 0; i <array.length; i++) {
        int x = (int) ( Math.random() * 100 );
        array[i]=x;
        System.out.println("The Number is: " + array[i]);
    }
   Arrays.sort(array);
   int index = array.length - 1;
   for (int i = 0; i < maxValues.length && index >= 0; i++) {
           maxValues[i]=array[index];
           index--;
       System.out.println( (i+1) +"Max is: " + maxValues[i] );
    }