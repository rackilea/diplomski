Fragment oldMapFrag = getSupportFragmentManager().findFragmentById(R.id.map);
if(oldMapFrag != null) {
    getSupportFragmentManager().beginTransaction().remove(oldMapFrag).commit();
    manager.popBackStack();
    ViewGroup container = (ViewGroup)findViewById(R.id.content);
    if(container != null)
        container.removeAllViews();
}