@Override
protected void onDestroy() {
    if(nmanager != null){
        nmanager.closeDatabase();
    }
    super.onDestroy();
}