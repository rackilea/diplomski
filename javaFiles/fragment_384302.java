public class Yahtzee  {
    private Dice[] dice;
    private final int DICE_COUNT=5;
    public Yahtzee(){
        dice=new Dice[DICE_COUNT];
        for(int i =0;i<DICE_COUNT;i++)
            dice[i] = new Dice();
        yahtzeeRoll(); //constructor
    }
    public void yahtzeeRoll(){         
        for(int i =0;i<DICE_COUNT;i++)
            dice[i].roll();
    }
    public void printYahtzee(){ //prints the dices and graphics         
        for(int i =0;i<DICE_COUNT;i++)
            System.out.println("dice "+(i+1)+" comes up= " + dice[i].value());
    }
}