//initialize array of size 10.
int[] array=new int[10];
//make copy of array
int[] arrayCopy=array.clone();
//expand array size by 1
array=new int[array.length+1];
//give value to new array index
array[array.length-1]=0;
//copy values from 'arrayCopy' to array
for(int x=0;x<arrayCopy.length;x++){
array[x]=arrayCopy[x];
}