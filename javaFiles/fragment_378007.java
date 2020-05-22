char arr[]=new char[myData.length()];
    arr=myData.toCharArray();

     for(int i = 0; i < arr.length; i++) {

       arr[i]=inputMap.get(arr[i]);

      System.out.println( arr[i]);
    }