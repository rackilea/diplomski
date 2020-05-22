DownloadMediaList task = new DownloadMediaList (MainAactivity.this,new TheInterface() {
             @Override
             public void theMethod(ArrayList<Media> result) {
                // result available here do whatever with list media
            }  
        });