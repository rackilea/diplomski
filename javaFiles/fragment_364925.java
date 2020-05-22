@Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
              Toast.makeText(getApplicationContext(), "tab1 active " + position, Toast.LENGTH_SHORT).show();      
           }
        }