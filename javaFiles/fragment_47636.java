Arrays.sort(array1);
Arrays.sort(array2);
int i=0;
int j=0;
int k=0;
System.out.println("Printing while processing");
while(i<array1.length && j<array2.length){
    if(array1[i]<array2[j]){
        array3[k]=array1[i];
        System.out.print(array3[k]+" ");
        i++;
    } else if(array2[j]<array1[i]){
        array3[k]=array2[j];
        System.out.print(array3[k]+" ");
        j++;
    } else{
        array3[k]=array1[i];
        System.out.print(array3[k]+" ");
        i++;
        j++;
    }
    k++;
}
// Finish the tail arrays
while (i < array1.length) {
    array3[k]=array1[i];
    System.out.print(array3[k]+" ");
    i++;
    k++;
}
while (j < array2.length) {
    array3[k]=array1[j];
    System.out.print(array3[k]+" ");
    j++;
    k++;
}