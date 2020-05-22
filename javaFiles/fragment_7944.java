@Override
public void onRowAdded(Row row) { 

    getActionBar().setTitle("Add Row");

    // This acts like your 'constructor'
    AddRowFragment fragment = AddRowFragment.newInstance(row);
    // fragment.setArguments(savedInstanceState);

    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit();
}