private class LoadGpsTask extends AsyncTask<String, Void, List<Gps>>                                             {
        @Override
        protected List<Gps> doInBackground(String... args) {
            //create folder if not exist
            boolean success = true;
            if (!dir.exists()) {
                success = dir.mkdir();
            }
            if (!success) {
                // Do something else on failure 
            }
            // CALL XMLPULLPARSER & RETURN A LIST           
            String files[] = dir.list(xmlFilter);