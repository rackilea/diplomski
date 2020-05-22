String numString = "1,2,3";

String[] splitString = numString.split(",");

int num1 = Integer.parseInt(splitString[0]);
int num2 = Integer.parseInt(splitString[1]);
int num3 = Integer.parseInt(splitString[3]); 

table = new double[4][5];
table[num1][num2] = num3;