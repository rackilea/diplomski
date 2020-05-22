Map<string,ArrayList<ShopItem>> dic = new HashMap<string,ArrayList<ShopItem>>();
for(/*...*/)
{
  string Manufacturer_Name = //you get the name
  if(/*the Manufacturer_Name is not in dic*/)
  {
    dic.put(Manufacturer_Name,new ArrayList<ShopItem>());
  }
  dic.get(Manufacturer_Name).Add(/*what you want to add*/);
}