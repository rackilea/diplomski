class MilkBottle implements Product
{
    int volume;

    @Override
    public String getName()
    {
        return "Milk (" + volume + "ml)";
    }

    @Override
    public String getCategory()
    {
        return "Grocery";
    }
}