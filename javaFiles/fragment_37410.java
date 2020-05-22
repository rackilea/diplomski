while(c5.isAfterLast() == false){   
    tipe = c5.getString(c5.getColumnIndex(TabRegistry.TYPE)); 
    status = c5.getString(c5.getColumnIndex(TabRegistry.STATUS)); 
    number = c5.getString(c5.getColumnIndex(TabRegistry.NUMBER)); 
    if (status.equals(comparisonString)){
        break;
    }
    c5.moveToNext();
}