// part of reading the values from command line and 
// putting them into this array is omitted
int[] array = ...;
int biggest = 0;
int occurance = 0;
for(int num : array) {
    if(num > biggest) {
        biggest = num;
        occurance = 0;
    }
    if(num == biggest) {
        occurance++;
    }
}
System.out.printf("Biggest number %s occured %s times.%n", biggest, occurance);