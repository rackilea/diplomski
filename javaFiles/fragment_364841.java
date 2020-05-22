List<String> name = new ArrayList<String>();
for (... ) {
   name.add(.... );
}
this.setListAdapter(new ArrayAdapter<String>(this,
                R.layout.row, R.id.label,
                name));