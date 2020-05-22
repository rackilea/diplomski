double doub[] = {0.5, 2.6, 3.7, 1.7, 4.6};
  long a[] = {1, 4, 3}; //

  Arrays.sort(a);
  for(double x : doub)
  {
      long key = Math.round(x);
      int index = Arrays.binarySearch(a, key);
      if(index < 0) // element wasn't found
           index = - index -1;
      if(index > a.length -1) // key is greater than the maximum element 
         index = a.length - 1;

      System.out.println("double: "+x+" rounded key: "+key+" value: "+a[index]);

  }