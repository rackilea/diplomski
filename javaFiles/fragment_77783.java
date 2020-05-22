int number1 = 6517253;
int number2 = 7195629;
int setValue = 12345; // Whatever the "set value" needs to be
boolean continueLooping = true;

while (continueLooping) {
    for (int i = number1; i <= number2; i++)
        doSomething();
    number1 = 0;
    number2 += setValue;
    if (<some-condition>)
        continueLooping = false;
}