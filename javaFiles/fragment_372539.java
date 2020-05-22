public class inc1{
    private inc1_player player;
    private inc1_dice dice;

    public inc1(inc1_dice dice, inc1_player player){
       this.dice = dice;
       this.player = player;
    }

    public inc1() {
        // here are actions you want to perform when constructor
        // taking no arguments is called...
    }
}