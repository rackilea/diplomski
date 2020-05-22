Random rand = new Random();
int r ;
do{
    r = rand.nextInt(200);
    if(r < 100 ){
        break;
    }
    System.out.println( r +"continue");
}while(true);
System.out.println( r + " stop");