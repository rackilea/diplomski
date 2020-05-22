private String[] PROJECTION { 
    Tasks._ID, 
    Tasks.TITLE, 
    Tasks.COMPLETED,
    Tasks.DUE_DATE + " as " + Tasks.DUE_DATE, 
    Tasks.IMPORTANCE + " as " + Tasks.DUE_DATE, 
    Tasks.NOTES + " as " + Tasks.NOTES
};