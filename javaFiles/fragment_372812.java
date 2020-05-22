StringBuilder strBuilder = new StringBuilder();
      for(int i = 0; i < <waht u need>; i++){
            String strName = detailArrayListFromDB.get(i).getName();
            int dbQty = detailArrayListFromDB.get(i).getQuantity();
            double dbTotal = detailArrayListFromDB.get(i).getTotal();

            Log.d("Name::--", strName);
            Log.d("QTY::--", ""+dbQty);
            Log.d("TOTAL::--", ""+dbTotal);


            strBuilder.append(" Name: "+strName);
            strBuilder.append(" Qty:" +dbQty);
            strBuilder.append(" Total:" +dbTotal);
    }
    String str = strBuilder.toString();
    Log.d("stringBuilder:", str);