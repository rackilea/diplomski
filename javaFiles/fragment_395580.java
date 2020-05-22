int number1 = randomGenerator.nextInt(100);
int number2 = randomGenerator.nextInt(100);

while(number1 == number2){
    number2 = randomGenerator.nextInt(100);
}