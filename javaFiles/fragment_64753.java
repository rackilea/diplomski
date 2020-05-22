ListView listView_ent = (ListView) findViewById(R.id.popular_apps_list_ent);
ArrayList<DataHolder> data_ent = new ArrayList( data);
for (int i = data_ent.size()-1; i >= 0; i--) {
    if(data_ent.get(i).getType().equals("edu")){
        data_ent.remove(i);
    }
}
listView_ent.setAdapter(new AppsAdapter(this, data_ent));

ListView listView_edu = (ListView) findViewById(R.id.popular_apps_list_edu);
ArrayList<DataHolder> data_edu = = new ArrayList( data);
for (int i = data_edu.size()-1; i >= 0 ; i--) {
    if(data_edu.get(i).getType().equals("ent")){
        data_edu.remove(i);
    }
}
listView_edu.setAdapter(new AppsAdapter(this, data_edu));