for (int i = 0; i < arr.length; i++) {
 if(i < adjcnt){
   if(i==0){
     csv = arr[i];
   }
   else{
         csv += ","+arr[i];
   }
}
 System.out.println("csv---> "+csv);
}