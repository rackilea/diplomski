Intent intent = getIntent();
    ArrayList<Item> mDATAFROMA = new ArrayList<>();
     try {
                    mDATAFROMA = intent.getParcelableArrayListExtra("ARRAY_DATA");
                    Log.d("ListSize",String.valueOf(mDATAFROMA.size()));
                } catch (Exception e) {
                    e.printStackTrace();
                }