//Example..
class CoinTosser
{
    private static Random rnd = new Random();
    private int currentFlip;  //this is also your last flip

    public void newFlip(){
        currentFlip = rnd.nextInt(2);  //in this case, no need to return toss result
    }

    public void flipCoin(int times){
        for(int i=0, i<times; i++){
            newFlip();
            System.out.println("Attemp "+ (i+1) + ":" + currentFlip==0?"Head":"Tail");
        }
    }
}