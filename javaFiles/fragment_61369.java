public class Card
{
    int rank; 

    // ...

    public String toString()
    {
        switch( rank )
        {
            case 1: return "Ace";
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10: return "" + rank;
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            default: return "INVALID CARD RANK";
        }
    }
}