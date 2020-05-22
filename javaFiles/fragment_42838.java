if (cursor.moveToFirst()) {                                                                  
do {                                                            
    String x  = cursor.getString(cursor.getColumnIndex("event_name"));                  
    System.out.println("Cursor ::::::" + x);                                            
    listViewModel.setEventDate(cursor.getString(cursor.getColumnIndex("event_date")));   
    modelList.add(listViewModel);                                                        
}while (cursor.moveToNext());