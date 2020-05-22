holder.setItemClickListener(new ItemClickListener() {

        @Override
        public void onItemClick(View v, int pos) {

            SharedPreferences sharePrefs = c.getSharedPreferences("busyDownloading", Context.MODE_PRIVATE);
            String getSharedUser = sharePrefs.getString("isItBusy", "");
            if (getSharedUser.equals("yes")){
                Toast.makeText(c, "You can only download one file at a time...", Toast.LENGTH_SHORT).show();

            }else {
             DownloadFileFromURL p = new DownloadFileFromURL();
             p.execute(pos + "", downloadLink);

            }

        }
    });