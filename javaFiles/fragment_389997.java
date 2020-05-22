int[] freq= new int[10];// Declare an array of size 10

while (i < 50){
int value = kbin.nextInt();
if (value >= 10 & value <= 19) {
    list[i] = value;

    freq[value-10]++; // Count the number in array position.
    i++;
} else {
    System.out.println("!! Bad number !!");    
   }
}

//Now, display the frequency of number.
for(int k=0;k<freq.length;k++){
  System.out.println("value : " +(k+10)+" frequency : "+freq[k]);
}