if (currentVersion.equals(serverVersion) == false) {
        new AsyncTask<Void, Void, Void>() {

            private ProgressDialog pDialog;

            @Override
            protected void onPreExecute() {
                pDialog = new ProgressDialog(context);
                pDialog.setMessage("DO NOT ROTATE YOUR DEVICE. /nI am upgrading your version, press OK then INSTALL in a minute. Please wait....");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(true);
                pDialog.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {

                    URL url = new URL(prefs.getString("server_address",
                            null) + "/updates/eduDroid.apk");
                    HttpURLConnection c = (HttpURLConnection) url
                            .openConnection();

                    String PATH = Environment.getExternalStorageDirectory()
                            + "/download/";
                    File file = new File(PATH);
                    file.mkdirs();
                    File outputFile = new File(file, "eduDroid.apk");
                    FileOutputStream fos = new FileOutputStream(outputFile);

                    InputStream is = c.getInputStream();

                    byte[] buffer = new byte[1024];
                    int len1 = 0;
                    while ((len1 = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, len1);
                    }
                    fos.close();
                    is.close();

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(new File(Environment
                            .getExternalStorageDirectory()
                            + "/download/"
                            + "file.apk")),
                            "application/vnd.android.package-archive");
                    context.startActivity(intent);

                } catch (IOException e) {
                    Toast.makeText(context, "Update error!",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected void onPostExecute(Void result) {
                pDialog.dismiss();
            }
        }.execute();
    }