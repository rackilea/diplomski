class SaveTask extends AsyncTask<Void, Void, Void> {

    ProgressDialog progressDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(R.style.NewDialog);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        String datafolder = Environment.getDataDirectory()
                .getAbsolutePath() + File.separator + "app";
        File customfolder = new File(Environment
                .getExternalStorageDirectory().getAbsolutePath().toString()
                + File.separator + "BackupApps");
        String comando = "cp -r /data/app /sdcard/BackupApps";
        Process suProcess = null;
        try {
            suProcess = Runtime.getRuntime().exec("su");
        } catch (IOException e3) {
            // TODO Auto-generated catch block
            e3.printStackTrace();
        }
        DataOutputStream os = new DataOutputStream(
                suProcess.getOutputStream());

        try {

            os.writeBytes(comando + "\n");

        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();

        }
        try {
            os.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            os.writeBytes("exit\n");

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            os.flush();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

}