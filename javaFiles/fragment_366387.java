Number number5 = 5;
Integer int5 = 5;
number5 = int5;  //OK

List<Number> listNumber5 = Arrays.asList(number5);
List<Integer> listInt5 = Arrays.asList(int5);
listNumber5 = listInt5; //ERROR

List<? extends Number> listExtendsNumber5 = Arrays.asList(number5);
listExtendsNumber5 = listInt5; // OK