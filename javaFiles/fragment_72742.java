public class ScoringService {

    public int calculate(Box box) {
        int score = 0;
        Jewel jewel = box.getJewel();

        if(box.getColor() == jewel.getColor() || box.getColor() == Color.WHITE) {
            score++;
        }

        if(!box.getColor().isPrimary() && jewel.getColor() == Color.WHITE) {
            score++;
        }    

        if(box.getColor().isPrimary() && !jewel.getColor().isPrimary()) {
            Set<Color> intersection = new HashSet<Color>(box.getColor().components());
intersection.retainAll(jewel.getColor().components());
            score += intersection.size();
        }

        return score;
    }
}