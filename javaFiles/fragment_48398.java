public void addProd(View ap)
{
    // test arraylist of hashmaps
    HashMap<String, String> prodHashMap = new HashMap<String, String>();
    prodHashMap.put("prod", tvProd.getText().toString());

    prodArrayList.add(prodHashMap);

    tvProd.setText("");

    // check data ///

    Log.e("myLog","Data prodArrayList in ADD Method Size = "+prodArrayList.size());

    for(int i=0; i< prodArrayList.size();i++)
    {
         Log.e("myLog","Data prodArrayList in ADD Method = "+prodArrayList.get(i).toString());
    }
}