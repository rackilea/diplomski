onCreate () {
setContentView(R.layout.frag_vocablist); 
    }

    public void onItemSelected(String id) {
    Bundle arguments = new Bundle();
    arguments.putString(“FragmentB_package”, id);


    FragmentB fragment = new FragmentB();
    fragment.setArguments(arguments);
    getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragment).commit();
}