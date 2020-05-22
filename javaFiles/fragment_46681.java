//обработка нажатия пункте списка
public void onListItemClick(){

}

//закрытие базы данных и курсора
@Override
public void onDestroy(){
    super.onDestroy();
    if (cursor!=null) cursor.close();
    if (db.isOpen()) db.close();
}