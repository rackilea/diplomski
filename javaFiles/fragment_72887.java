public class Wheel{
    Stack<PrizeCard> prizes;
    public Wheel(){
        prizes = new Stack<PrizeCard>();
        //populate prizes here
    }

    public PrizeCard spinWheel(){
        return prizes.isEmpty() ? null : prizes.pop();
    }
}