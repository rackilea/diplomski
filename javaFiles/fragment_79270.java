ArrayList myItems = new ArrayList<ListViewItem>();
for (int i = 0; i < c.getColumnCount(); i++) {
    Title = c.getString((c.getColumnIndex("NOM_OFER")));
    Preu = c.getColumnIndex("PREU_OFERTA");
    percent = c.getString((c.getColumnIndex("PERCENTDESCOMPTE")));
    data_f = c.getString((c.getColumnIndex("DATA_F")));

    // create and add your items as they are retrieved from the db
    myItems.add(new ListViewItem(...,Title, Preu, percent, data_f));

    ...
} ...