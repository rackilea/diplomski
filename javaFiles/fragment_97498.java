public void TextFileReader (){

        String[][] textFileData = new String[5][2];

        InputStreamReader InputSR = null;
        BufferedReader BufferedRdr = null;
        String thisLine = null;

        InputSR = new InputStreamReader(getResources().openRawResource(R.raw.text_file));
        BufferedRdr = new BufferedReader(InputSR);

        try {
            // open input stream text_file for reading purpose.
            int i = 0;
            while ((thisLine = BufferedRdr.readLine()) != null) {
                String[] parts = thisLine.split(" ");
                textFileData[i][0] = parts[0];
                textFileData[i][1] = parts[1];
                Log.v("String Array"+i+"0", String.valueOf(textFileData[i][0]));
                Log.v("String Array"+i+"1", String.valueOf(textFileData[i][1]));
                i = i +1;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }