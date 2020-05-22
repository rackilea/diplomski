@Override
public boolean onCreateOptionsMenu(Menu menu) {
    //this.optionsMenu = menu;
    //MenuInflater inflater = getMenuInflater(); //ERROR<-----------
    getMenuInflater().inflate(R.menu.main, menu);
    //return super.onCreateOptionsMenu(menu); // in Fragment cannot be applied <------------
    return true;
}