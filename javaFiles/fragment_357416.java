for (int i = 0; i < arr.length; i++) {
 if((i % adjcnt) < adjcnt){
   if((i % adjcnt)==0){
     csv = arr[i];
   }
   else{
         csv += ","+arr[i];
   }
}
 System.out.println("csv---> "+csv);
}