int sum = 0; //Declare a variable to keep track of your sum
for (String number : after.split ("\\s+")) {
    int v = Integer.parseInt (number);
    System.out.println (v);
    numbers.add(v);
    sum += v; //Each iteration of your loop add the current int to your sum
}
System.out.println(sum);