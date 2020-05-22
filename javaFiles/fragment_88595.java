Fragment currentFrag = getSupportFragmentManager().findFragmentById(R.id.content);
if(currentFrag != null) {
    getSupportFragmentManager().beginTransaction().remove(currentFrag).commit();
    manager.popBackStack();
}
View mapView = inflator.inflate(R.layout.store_finder, container, true);