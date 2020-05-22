for(Object[] myobject : mydata){
    // Note that java.sql.Date extends java.util.Date
    if (myobject[1] instanceof java.util.Date) {
        java.util.Date mydate = (java.util.Date) myobject[1];
    }
}