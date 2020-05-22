//Performing action onItemSelected and onNothing selected
@Override
public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {

    if(position < spnKolom.length - 1)
    {
        spnKolom[position + 1].setVisibility(View.VISIBLE);
    }

}

@Override
public void onNothingSelected(AdapterView<?> arg0) {
    // TODO Auto-generated method stub
}