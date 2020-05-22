interface Product
{
    public String getName();
    public String getCategory();
}

class Shirt implements Product
{
    @Override
    public String getName()
    {
        return "Shirt";
    }

    @Override
    public String getCategory()
    {
        return "Clothing";
    }
}