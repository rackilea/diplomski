byte[] data = bos.toByteArray(); // Use This or the code in comments below

/*  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    bitmap.compress(CompressFormat.PNG, 0, outputStream);       
    byte[] data = outputStream.toByteArray();*/

insertStatement_logo.bindLong(1, id);       
insertStatement_logo.bindBlob(2, data);

insertStatement_logo.executeInsert();
insertStatement_logo.clearBindings() ;