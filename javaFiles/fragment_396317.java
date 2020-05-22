private class LoadFilesTask extends AsyncTask<String, Integer, Long> {
    protected Long doInBackground(String... str) {
        long lineNumber = 0;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new
                    InputStreamReader(context.getAssets().open(str[0]));
            Scanner inputStream = new Scanner(inputStreamReader);
            inputStream.nextLine(); // Ignores the first line

            while (inputStream.hasNext()) {
                lineNumber++;
                String data = inputStream.nextLine(); // Gets a whole line
                String[] line = data.split(","); // Splits the line up into a string array

                if (line.length > 1) {
                    // Do stuff, e.g:
                    String value = line[1];
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineNumber;
    }

    //If you need to show the progress use this method
    protected void onProgressUpdate(Integer... progress) {
        setYourCustomProgressPercent(progress[0]);
    }

    //This method is triggered at the end of the process, in your case when the loading has finished
    protected void onPostExecute(Long result) {
        showDialog("File Loaded: " + result + " lines");
    }
}