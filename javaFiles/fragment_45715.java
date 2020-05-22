public List<Produtos> buscar() {

    SQLiteDatabase db = this.getReadableDatabase();

    List<Produtos> list = new ArrayList<Produtos>();
    String[] colunas = new String[]{"_id", "item", "coligada", "filial"};

    Cursor cursor = db.rawQuery("select * from produtos2", null);

    if (cursor.getCount() > 0) {
        cursor.moveToFirst();

        do {

            Produtos p = new Produtos();
            p.setId(cursor.getLong(0));
            p.setItem(cursor.getString(1));
            p.setColigada(cursor.getString(2));
            p.setFilial(cursor.getString(3));
            list.add(p);

        } while (cursor.moveToNext());
    }

    return (list);
}