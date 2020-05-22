public class Events_List {
public long id;
public String list_item_title;
public String list_item_price;
public String list_item_description;
public Uri url;

public Events_List(long id, String list_item_title, String list_item_description, String list_item_price, Uri url){
    this.id = id;
    this.list_item_title = list_item_title;
    this.list_item_description = list_item_description;
    this.list_item_price = list_item_price;
    this.url = url;
}

public String getList_item_title()
{
    return this.list_item_title;
}

public String getList_item_price()
{
    return this.list_item_price;
}

public String getList_item_description()
{
    return this.list_item_description;
}

}