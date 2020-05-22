public void dataManipulation(ArrayList<CursorContainer> list, CursorContainerFactory factory, Cursor cursor){
    cursor.moveToFirst();
    for (int i = 0; i < cursor.getCount(); i++) {
        list(factory.create(cursor));
        if (!cursor.isAfterLast())
            cursor.moveToNext();

}