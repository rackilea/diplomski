Cursor incmoningCursor = getUserLogedIn("select * from Registration where username="+incomingUserEmail+ "and password="+incmoingPassword,db)
try {
    while (cursor.moveToNext()) {
        ...
       //read out the cursor and compare each string with your        //editTextString here
    }
} finally {
    cursor.close();
}
}