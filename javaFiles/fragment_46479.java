int PriceTotal = 0;
        for(String totalString : shoppingList){
            totalString = totalString.replaceFirst("\\d", "");
            totalString = totalString.replaceAll("[\\D]","");
            PriceTotal += Integer.parseInt(totalString);
        }

        Log.i("test Price =", String.valueOf(PriceTotal)); // delete it thats is for testing you can use it in app to test reslts 

        /*Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,PriceTotal, duration);
        toast.show();*/
        Toast.makeText(this, String.valueOf(PriceTotal), Toast.LENGTH_LONG).show();  //thats is simpler it you want