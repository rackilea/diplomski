String headerRow= " * |"; 
String spacer = "-----";
for(int i=1; i<secondInt + 1; i++){headerRow+="   "+i; spacer+="----";}
System.out.println(headerRow);
System.out.println(spacer);
int counter = 1;
for (int i = 1; i < firstInt + 1; i++) {
    System.out.printf("%4s", i + " |");
    for (int j = 1; j < secondInt + 1; j++) {
        System.out.printf("%4d", counter);
        counter++;
    }
    System.out.println();
}