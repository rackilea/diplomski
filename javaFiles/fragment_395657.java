@Override
public void apply(String data, String tag) {
    FragmentManager fm = getSupportFragmentManager();
    Frag_list frag_list = (Frag_list) fm.findFragmentByTag(tag);
    //Fallback plan in case the fragment has not been created.
    if(frag_list == null) {
        frag_list = new Frag_list();
        //Include the fragment for future reference.
        //This fragment has no view
        fm.beginTransaction().add(frag_list, tag);
    }
    frag_list.addItem(data);
}