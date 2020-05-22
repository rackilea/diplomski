grupa = "Płeć";                             //declare as String
dzieci = {"Kobieta","Mężczyzna"};           //declare as String[]
customAdapter = new CustomAdapter (this, grupa, dzieci);
expandableListView.setAdapter(customAdapter);
expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int group, int position, long id) {

        String tekst = (String) parent.getExpandableListAdapter().getChild(group,position);
        parent.collapseGroup(group);

        Toast.makeText(getApplicationContext(), tekst ,Toast.LENGTH_SHORT).show();
        grupa = dzieci[position];
        customAdapter = new CustomAdapter (yourApplication.this, grupa, dzieci);
        expandableListView.setAdapter(customAdapter);
        return false;
    }
});