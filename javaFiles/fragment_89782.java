if(cacheDir.isDirectory()){
        File[] files=cacheDir.listFiles();

        for(File file:files){
            if(null != file){


                long lastModified = file.lastModified();

                if (0 < lastModified) {
                    Date lastMDate = new Date(lastModified);
                    Date today = new Date(System.currentTimeMillis());

                    if (null != lastMDate && null != today) {
                        long diff = today.getTime() - lastMDate.getTime();
                        long diffDays = diff / (24 * 60 * 60 * 1000);
                        if (15 < diffDays) {
                            file.delete();
                        }
                    }
                }

            }
        }
    }