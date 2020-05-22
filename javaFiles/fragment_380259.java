public int returnLargest() {
    if (num1 >= num2 && num1 >= num3)
        return num1;
    if (num2 >= num3)
        return num2;
    return num3;
}