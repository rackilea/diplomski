SQliteDatabase databaseWorking;
Cursor csr = databaseWorking.getRowsToDelete();
int initialrowwcount = csr.getCount();
int deletecount = 0;
while (csr.moveToNext()) {
     //....... your insertion code .....
    if (response == 200) {
        if (databaseWorking.deleterow(csr.getLong(csr.getColumnIndex("Id"))) < 1) {
            System.out.println(" Row with Id " +
                csr.getLong(csr.getColumnIndex("Id")) + 
                " was not deleted.");
        } else {
            deletecount++;
        }
    }
}
csr.close();
System.out.println("Out of " +
        Integer.toString(initialrowcount) +
        " rows, " +
        integer.toString(deleteccount) +
        " rows were deleted.";
}