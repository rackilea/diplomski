System.out.println();
System.out.print("Please Enter The First Number: ");
double numb1 = s1.nextDouble();
System.out.println();
System.out.print("Please Enter The Second Number: ");
double numb2 = s1.nextDouble();
double res;
String operation = "";

switch (choice) {
    case 1:
        res = f.sum(numb1, numb2);
        operation = "Sum";
        break;
    case 2:
        res = f.subtract(numb1, numb2);
        operation = "Substraction";
        break;
    case 3:
        res = f.multiply(numb1, numb2);
        operation = "Multiplication";
        break;
    case 4:
        res = f.divide(numb1, numb2);
        operation = "Divison";
        break;
    default:
        res = 0;
        System.out.println();
        System.out.println("Please Enter a Valid Choice from 1 to 4");
}

System.out.println();
System.out.println("The " + operation + " Of Two Numbers is: " + res);