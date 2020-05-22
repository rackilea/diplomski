public class Card implements Comparable<Card>
{
    ...

    @Override
    public int compareTo(Card o) {
        if (this.rank.getRankValue() < o.rank.getRankValue()) {
            return -1;
        }
        else if (o.rank.getRankValue() < this.rank.getRankValue()) {
            return 1;
        }
        return 0;
    }
}