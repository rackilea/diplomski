@XmlRootElement(name = "Items")
public class Items
{

    @XmlElementWrapper( name = "Items")
    private List<Item> items = new ArrayList<Item>();


    public List<Item> getItemList() 
    {
       return this.items;
    }

    @XmlElement(name = "Item")
    public void setItemList( List<Item> items )
    {
        this.items = items;
    }

}