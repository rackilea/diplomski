public class TechnologyEquipment
{
    private double price;
    private String name;
    private String description;


    public TechnologyEquipment
    {
        this.price = 0.0;
        this.name = "";
        this.description = "";
    }


    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setDesription(String description)
    {
        this.description = description;
    }


    public double getPrice()
    {
        return this.price;
    }
    public String getName()
    {
        return this.name;
    }
    public String getDescription()
    {
        return this.description;
    }
}