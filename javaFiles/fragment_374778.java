while(data.moveToNext()){
    taskList.add(data.getString(1));

}

listView.setAdapter(cursorAdapter);