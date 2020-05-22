for (int i = 0; i < list.length-1; i++)        
   for (int j = i+1; j < list.length; j++)
       if (list[j] < list[i]) {
           int temp = list[j];
           list[j] = list[i];
           list[i] = temp;
       }       
for (int k = 0; k < list.length; k++) {
   System.out.print(list[k] + ", ");
}