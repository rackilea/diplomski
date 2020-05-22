class LoadAllIcosSD extends AsyncTask<String, String, String> {

    /**
     * Before starting background thread Show Progress Dialog
     * */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(SynchroIcoActivitySD.this);
        pDialog.setMessage(getString(R.string.progdata));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }


    protected String doInBackground(String... args) {

        try {

            String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
            String fileName = "/myfolder/filename.csv";
            File myFile = new File(baseDir + File.separator + fileName);

            if(myFile.exists()){
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(
                    new InputStreamReader(fIn));
            String aDataRow = "";
            String aBuffer = "";
            //how many row
            int ip=0;

            while ((aDataRow = myReader.readLine()) != null) {
                aBuffer += aDataRow + "\n";
                ip = ip+1;

            }

            String kosikx = aBuffer;
            myReader.close();

            String delims = "[\n]+";
            String delims2 = "[;]+";

            String[] riadokxxx = kosikx.split(delims);

            for (int i = 0; i < riadokxxx.length; i++) {
            String riadok1 =  riadokxxx[i];

            String[] polozkyx = riadok1.split(delims2);
            String icox =  polozkyx[0];
            String naix =  polozkyx[3] + " " + polozkyx[6];

            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();

            // adding each child node to HashMap key => value
            map.put(TAG_PID, icox);
            map.put(TAG_NAME, naix);
            map.put(TAG_PRICE, "!!");

            // adding HashList to ArrayList
            productsList.add(map);
                 }
            }//iffileexist



        } catch (Exception e) {

        }


        return null;
    }

    /**
     * After completing background task Dismiss the progress dialog
     * **/
    protected void onPostExecute(String file_url) {
        // dismiss the dialog after getting all products
        pDialog.dismiss();
        // updating UI from Background Thread
        runOnUiThread(new Runnable() {
            public void run() {
                /**
                 * Updating parsed JSON data into ListView
                 * */
                ListAdapter adapter = new SimpleAdapter(
                        SynchroIcoActivitySD.this, productsList,
                        R.layout.list_item_icosd, new String[] { TAG_PID, TAG_NAME, TAG_PRICE},
                        new int[] { R.id.pid, R.id.name, R.id.price });
                // updating listview
                setListAdapter(adapter);
            }
        });

    }

}