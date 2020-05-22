//This method loads test scores into an array and populates spinner
    public void nameArrayListMethod (){

        InputStreamReader InputSR = null;
        BufferedReader BufferedRdr = null;
        String thisLine = null;

        AssetManager am = getAssets();
        String[] SpinnerNames = new String[3];

        try {
            InputSR = new InputStreamReader(am.open("scoresdata/test_scores.txt"));
            BufferedRdr = new BufferedReader(InputSR);

            // open input stream test_scores for reading purpose.

            int i = 0;
            while ((thisLine = BufferedRdr.readLine()) != null) {
                 //System.out.println(thisLine);

                String[] parts = thisLine.split(" ");
                testScoreList[i][0] = parts[0];
                testScoreList[i][1] = parts[1];
                testScoreList[i][2] = parts[2];

                SpinnerNames[i] = testScoreList[i][0]; //Extract first column for spinner
                //System.out.println(testScoreList[i][0] + " " + testScoreList [i][1] + " " + testScoreList[i][2]);
                                i = i +1;
            }
            BufferedRdr.close();
            InputSR.close();

        } catch (Exception e) {
            e.printStackTrace();

        }


        spinner= (Spinner) findViewById(R.id.spinner1);
         ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, SpinnerNames);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

    }