Scanner sc = new Scanner(new File("myfile.txt"));
double firstNumber = sc.nextDouble();
String operation = sc.next("[+-/\\*]");
double secondNumber = sc.nextDouble();

double result;
if("+".equals(operation))
  result = firstNumber + secondNumber;
else if("-".equals(operation))
  result = firstNumber - secondNumber;
else if("*".equals(operation))
  result = firstNumber * secondNumber;
else if("/".equals(operation))
  result = firstNumber / secondNumber;
else
  System.out.println("Operation unrecognized");

System.out.println(firstNumber + operation + secondNumber + " = " + result);