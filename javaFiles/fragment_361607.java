private void listOrder(String itemValue, String itemID)
{   
    HashMap<String, String> map = new HashMap<String, String>();

    String quantity = "1";

    map.put(FOODID3, itemID);
    map.put(FOODNAME3, itemValue);  
    map.put(FOODQUANTITY3, quantity);

    boolean found = false;

    if (!LIST3.isEmpty())
    {
        for (int i = 0; i < LIST3.size(); i++)
        {
            String exists = null;
            exists = LIST3.get(i).get(FOODID3).toString();

            if (exists.equals(itemID))
            {
                found=true;
                String b = LIST3.get(i).get(FOODQUANTITY3);
                int quantityy = Integer.parseInt(b) +1;
                String c = Integer.toString(quantityy);
                System.out.println(c);
                LIST3.get(i).put(FOODQUANTITY3, c); // I can't update the value here
                break;
            }
        }
    }               

    if (!found)
    {
        LIST3.add(map);
    }

    LISTORDER = (ListView) findViewById(R.id.listOrder);

    List3Adapter adapter = new List3Adapter(MainActivity.this, LIST3);
    LISTORDER.setAdapter(adapter);
}