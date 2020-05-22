public ArrayList<String> getListofevents(String evName,String attribute) {

    ArrayList<String> arrAux = new ArrayList<String>();

    datab = getActivity().openOrCreateDatabase(evName, Context.MODE_PRIVATE, null);

    Cursor crs = datab.rawQuery("SELECT * FROM event", null);

    while(crs.moveToNext()){
                String uname = crs.getString(crs.getColumnIndex(attribute));
          Log.e("The string is : ", uname);
          arrAux.add(uname);
     }
     crs.close();
     datab.close();


    return arrAux;
}