void quickSort(int left, int right, int tab[]){
     int i = left;
     int j = right;
     int buffer;
     int pivot = tab[(i+j)/2];

     do{
         while (tab[i] < pivot) i++;
         while (tab[j] > pivot) j--;
         if (i <= j){
                   buffer = tab[i];        //swap.
                   tab[i] = tab[j];
                   tab[j] = buffer;
                   i++;
                   j--;
         }
     }
     while (i <= j);

     if (left < j) qs(left, j, tab);
     if (i < right) qs(i, right, tab);
}