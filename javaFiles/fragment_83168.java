for(int i = 0; i < list.length - 1; i++) {
   min = i;
   for(int j = i + 1; j < list.length; j++) {
      if(list[j] < list[min]){
          min = j;
      }
   }
   temp = list[min]; 
   list[min] = list[i]; 
   list[i] = temp;

}