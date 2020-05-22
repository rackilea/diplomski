buttonSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
{
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String selectedItem = parent.getSelectedItem().toString();

        if (selectedItem.equals("Ultimos 10 lancamentos"))
        {
            textView.setVisibility(View.VISIBLE);
        }
    }

    public void onNothingSelected(AdapterView<?> parent)
    {
    }
});