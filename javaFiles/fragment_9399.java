Object columnNames[] = { "Title", "Rating", "Year", "Genre", "Cast" };
DefaultTableModel model = new DefaultTableModel(columnNames, 0);

for(Film film : filmList.getFilmDB()) 
{
    Vector<Object> row = new Vector<Object>(5)
    row.addElement( film.getFilmName() );
    row.addElement( film.getFilmRating() );
    ...
    model.addRow( row );
}

JTable mainTable = new JTable(model);