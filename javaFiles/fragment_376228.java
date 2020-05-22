private void saveStreamToFile(InputStream responseStream){
    try{
        byte[] buf = new byte[1024];int len;
        FileOutputStream out = getActivity().openFileOutput(
                "SQLIITE_FILE_NAME", Context.MODE_PRIVATE);
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        out.close();
        in.close();
        responseStream.close();

        SQLiteDatabase appDb = SQLiteDatabase.openDatabase(this.getFilesDir()
                .getAbsolutePath()+"/SQLITE_FILE_NAME.db", null
                ,SQLiteDatabase.NO_LOCALIZED_COLLATORS
                |SQLiteDatabase.OPEN_READONLY);
    }catch(IOException e){
        e.printStackTrace();
    }catch(Exception e){
        e.printStackTrace();
    }
}