if (status_zwart == true){
    getSupportFragmentManager()
        .beginTransaction()
        .add(R.id.fragment_container, topFragment)
        .commit();
    status_zwart = false;
}
if (status_zwart == false) {
    getSupportFragmentManager()
        .beginTransaction()
        .remove(topFragment)
        .commit();
    status_zwart = true;}
}