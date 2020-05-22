public static int opX(int num1, int num2)
{
    if(num1 < 5 && num2 < 5)
        return (num1 + num2) % 5;
    if(num1 < 5 && num2 >= 5)
        return (num1 + (num2 - 5)+5) % 5 + 5;
    if(num1 >= 5 && num2 < 5)
        return ((num1 - 5) - num2+20) % 5 + 5;
    return (num1 - num2 +10) % 5;
}