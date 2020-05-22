public boolean onOptionsItemSelected(MenuItem item) {
  switch(item.getItemId()){
    case R.id.nav_About:{
      AboutActivity about = new AboutActivity();
      about.popup(this);
  }
}