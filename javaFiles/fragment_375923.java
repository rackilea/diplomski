public void readDownloadManager() {
                DownloadManager.Query query = null;
                DownloadManager downloadManager = null;
                Cursor c = null;
                try {
                    query = new DownloadManager.Query();
                    downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);

                    //Just for testing I initiated my own download from this url. When an http
                    // reuest for this url is made, since download is taking place, it gets saved in
                    // the download manager.
                    Request request = new Request(Uri.parse("http://ocw.mit.edu/courses" +
                            "/aeronautics-and-astronautics/16-100-aerodynamics-fall-2005" +
                            "/lecture-notes/16100lectre1_kvm.pdf"));
                    downloadManager.enqueue(request);
                    query.setFilterByStatus(DownloadManager.STATUS_PENDING);
                    c = downloadManager.query(query);

                    if(true){
                        int statusColumnIndex = c.getColumnIndex(DownloadManager.COLUMN_STATUS);
                        int urlColumnIndex = c.getColumnIndex(DownloadManager.COLUMN_URI);
                        long downloadProcessIdColumnNo = c.getColumnIndex(DownloadManager.COLUMN_ID);
                        Log.d("Column Count", ((Integer)c.getCount()).toString());
                        if(c.getCount() > 0){
                            String url="";
                            c.moveToLast();
                            if(c.isLast()){
                                url = c.getString(urlColumnIndex);
                                downloadManager.remove(downloadProcessIdColumnNo);
                                Log.d("Count after remove", ((Integer)c.getCount()).toString());
                            }
                            Log.d("After", "Stopped Working");

                            //Here I am sending the url to another activity, where I can work with it.
                            Intent intent = new Intent(EasyUploadMainMenu.this, EasyUploadActivity.class);
                            Bundle b = new Bundle();
                            b.putString("url", url);
                            intent.putExtras(b);
                            startActivity(intent);
                            Log.d("url:", url);
                        }
                    }

                } catch (NullPointerException ex) {
                    ex.printStackTrace();
                }
            }