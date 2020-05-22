spinner.setOnItemSelectedListener(new MyCustomListener());


private class MyCustomListener implements OnItemSelectedListener
{
 @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3){
        // Write your logic what you want to do on selecting the item
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}