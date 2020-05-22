System.out.println("  " + number1 + " +");
for(int i = 0; i < (number1.length() - number2.length()); i++){
    System.out.print(" ");
}
System.out.println("  " + number2);
System.out.print(" ");
for(int j = 0; j < ((number1.length() - number2.length())+ number2.length()+1); j++){
    System.out.print("-");
}
System.out.println();
System.out.print("  " + total);