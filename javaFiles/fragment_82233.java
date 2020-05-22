private void getFile() {
    Log.i("Console","getFile");
    FileInputStream fin;
    String receiveString;
    String data;
    boolean copy = false;
    boolean finish = false;
    try {
        fin = context.openFileInput(TEST_FILE);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fin, "UTF-8"), 1024);
        StringBuilder stringBuilder = new StringBuilder();
        while ((receiveString = bufferedReader.readLine()) != null) {
            String formatted_end = end.substring(0, end.length() - 1);
            if (receiveString.equals(formatted_end)) finish = true;
            if (copy && !finish) stringBuilder.append(receiveString);
            String formatted_start = start.substring(0, start.length() - 1);
            if (receiveString.equals(formatted_start)) copy = true;
        }
        fin.close();
        data = new String(String.valueOf(stringBuilder).getBytes(), Charset.forName("UTF-8"));
        this.loadList(data);
    }
    catch (FileNotFoundException e) { Log.i("Console", "ERROR: " + e.getMessage()); }
    catch (IOException e) { Log.i("Console", "ERROR: " + e.getMessage()); }
    catch (Exception e) { Log.i("Console", "ERROR: " + e.getMessage()); }
}