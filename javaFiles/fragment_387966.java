int number = 0;
int max = Integer.MIN_VALUE; //Give lowest 'int' number (-2147483648) if your file has -ve numbers also.
int min = Integer.MAX_VALUE; //Highest value for int
while(file.hasNext()) {
    number = file.nextInt();
    if(number > max) {
        max = number; //assuming you have all positive numbers in your file
    }
    if(number < min) {
        min = number;
    }
}