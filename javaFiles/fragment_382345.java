class Player
{
    public String name;
    public int currentBid = 0;

    public Player(String name)
    {
        this.name = name;
    }

    public void bid(int amount)
    {
        this.currentBid = amount;
    }
}