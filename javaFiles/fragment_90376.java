int num;
boolean find = false;
   int[] a={2, 3, 4,7, 9};
   System.out.println("enter a no");
   num= in.nextInt();
   for(int i=0; i<a.length; i++){

       if(num==a[i]){
          find = true; 
          break;
       }
   }
System.out.println("Find = " + find);