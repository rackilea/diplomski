int counter = 0;
for (int i = 0; i < 10; i += 2) {
 for (int j = 0; j < 20 - i; j++) {
  System.out.print(" ");
 }
 for (int k = 0; k <= i; k++) {
  System.out.print(" " + counter++);
  if(counter > 9) counter = 0;
 }

 System.out.println();
}