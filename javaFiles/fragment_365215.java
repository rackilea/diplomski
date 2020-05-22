public class Player {
    private int speed;

       public Player(int speed){
           this.speed=speed;
       }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }      
}




public class Battle {

    Player player;

    static void battle(Player obj1, Player obj2){
        if (obj1.getSpeed() > obj2.getSpeed()){
            System.out.println("Faster");
        }
        else{
            System.out.println("Slower");
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Player player1 =new Player(5);

        Player player2 = new Player(3);

        battle(player1,player2);


    }

}