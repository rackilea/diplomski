for (int i=0; i<=N-9; i+=9) {
 System.arrayCopy(arrayN, i, a1, 0, 3);
 System.arrayCopy(arrayN, i+3, a2, 0, 3);
 System.arrayCopy(arrayN, i+6, a3, 0, 3);
 // presumably do other stuff here
}