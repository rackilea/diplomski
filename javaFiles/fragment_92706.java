public class property
{
    private String propertyname;
    private String owner;
    private double price;
    private double rent;

    public String getPropertyName()
    {
        return propertyname;
    }

    public void setPropertyName(string newName)
    {
        propertyname = newName;
    }

    // more getter/setter methods here

    public property(String propertyname, String owner, double price, double rent)//constructor
    {
        this.propertyname = propertyname;
        this.owner = owner;
        this.price = price;
        this.rent = rent;

        System.out.println("Property info for " + propertyname + " - Rent : £" + rent + "Price : £" + price + "owned by :" + owner);

    }
}