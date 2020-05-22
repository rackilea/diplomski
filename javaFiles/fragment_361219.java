Runnable runnable = new Runnable() {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                public void run() {

                    // messageText.setText("uploading started.....");
                    // ProgressDialog progress = new ProgressDialog(null,
                    // serverResponseCode);
                    // progress.setTitle("Loading");
                    // progress.setMessage("Wait while loading...");
                    // progress.show();

                }
            });

            File folder = new File(Environment.getExternalStorageDirectory()
                    .toString() + "myfolder");

            File dir = new File(folder.toString());
            boolean exists = dir.exists();
            System.out.println("boolean value is " + exists);

            // uploadFile(folder + "/My_File.png");

            // IF NOT FILES REDIRECT TO NO FILES ACTIVITY

            if (!exists) {

                // Thread.currentThread().interrupt();
                Log.v("ARCHIVOS NO ENCONTRADOS", folder.toString());




                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(UploadToServer.this, NoFiles.class);
                        startActivity(i);

                        threadMenu.stop();
                    }
                });

            }


        }
    };