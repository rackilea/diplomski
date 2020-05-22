String[] array = "$1,234,24 $233,424,323 $15,324,132".replaceAll("[$,]", "").split(" ");
int sum = 0;
for (String element : array) {
    sum += Integer.parseInt(element);
}
System.out.println("sum = " + sum);