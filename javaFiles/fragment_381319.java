class DownloadFile1 extends AsyncTask<String, Integer, String> {
    ProgressDialog bar;
    public String videoToDownload;
    public String fileName;
    private Context mContext;

    public DownloadFile1(Context context)
     {
      mContext=context;  
     }
    @Override
    protected void onPreExecute()
    {
       super.onPreExecute();
       bar = new ProgressDialog(mContext);
       bar.setMessage("Processing...");
       bar.setIndeterminate(true);
    }

    @Override
    protected String doInBackground(String... params) {
        int count;

        try {
            mp4load(videoToDownload);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

    @Override
    protected String onPostExecute()
    {
      super.onPostExecute(result);
      bar.dismiss();
    }

    public void mp4load(String urling) {
        try {
            System.out.println("Downloading");
            URL url = new URL(urling);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            //c.setDoOutput(true);
            con.connect();

            // String downloadsPath = Environment.getExternalStoragePublicDirectory();
            File SDCardRoot = Environment.getExternalStorageDirectory();

            File outputFile = new File(SDCardRoot, fileName);

            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(outputFile);

            int status = con.getResponseCode();

            InputStream is = con.getInputStream();

            byte[] buffer = new byte[1024];
            int len1 = 0;
            while ((len1 = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len1);
            }
            fos.close();
            is.close();
            System.out.println("Downloaded");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }