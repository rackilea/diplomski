public void onBindViewHolder(final Chat_Adapter.ViewHolder holder, int position) {

         //Initialize filetype here

        new DownloadFileFromFS(Download_URL, FileName + "."+ filetype, new AsyncTaskCallback() {
            @Override
            public void onSuccess(String filePath) {
                //HERE I NEED THE RESULT FROM ASYNCTASK AND WAIT TILL DOWNLOAD COMPLETES
                //THEN SET THE VIEWS WITH RETURN RESULT FROM ASYNCTASK

                if (filePath != null) {
                    File file = new File(filePath);
                    long sizeFile = file.length() / 1024; //In KB
                    holder.Doc_FileName.setText(filePath);
                    holder.Doc_FileSize.setText(String.valueOf(sizeFile));
                } else {
                    Log.d(TAG, "DOWNLOAD FILE PATH IS NULL");
                }
            }
        }).execute();
    }