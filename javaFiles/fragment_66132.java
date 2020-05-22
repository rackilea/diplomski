Spinner selectCat = (Spinner) findViewById(R.id.categoryChoose);
selectCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
{
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {
        displaySearch();
    }
    public void onNothingSelected(AdapterView<?> parent)
    {
        // Do nothing
    }
});