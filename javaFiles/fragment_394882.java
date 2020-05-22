public boolean onOptionsItemSelected(MenuItem item){
    int id = item.getItemId();

    switch(id){
        case R.id.jaren_3de:
            updateKlassenList(klassen);
            break; 
        case R.id.jaren_4de:
            updateKlassenList(klassen2);
            break; 
        case R.id.jaren_5de:
            updateKlassenList(klassen3);
            break; 
        case R.id.jaren_6de:
            updateKlassenList(klassen4);
            break; 

        // case R.id. 

    } 

    return super.onOptionsItemSelected(item);
}

private void updateKlassenList(String[] data) {
    klassenList.clear();
    klassenList.addAll(Arrays.asList(data));

    // I assume "adapter" is the adapter of interest.
    adapter.notifyDataSetChanged();
}