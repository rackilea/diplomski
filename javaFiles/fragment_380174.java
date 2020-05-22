String equation = null;
for (int i = 0; i < numOfOperatrions; i++) {
    equation += numbers.get(i);
    equation += operations.get(i);
}
equation += numbers.get(numbers.size() -1);    //Add the last number to the equation