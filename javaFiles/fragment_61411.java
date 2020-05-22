double random = Math.random();
if (random < 0.5) {
    System.out.println("H");
} else { // if it is not "< 0.5", then surely it is "> 0.5" (can't be equal to 0.5)
    System.out.println("T");
}