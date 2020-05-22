Random rand = new Random();
int r ;
for(r = rand.nextInt(200); r >= 100; r = rand.nextInt(200)){
    System.out.println( r +"continue");
}
System.out.println( r + " stop");