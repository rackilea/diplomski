final AsyncTask<Object,Object,String> task = new AsyncTask<Object,Object,String>() {
   protected String doInBackground(Object... o) {
        try {
            URL site = new URL("http://m.uploadedit.com/b029/1393133970157.txt");
            Scanner s = new Scanner(site.openStream());
            return s.nextLine();
        }
        catch(MalformedURLException e) { 
            throw new RuntimeException("Incorrect URL", e);
        }
        catch(IOException e) {
            throw new RuntimeException("Can't fetch file content from url", e);
        }   
   }

   protected void onPostExecute(String r) {
       Toast.makeText(getApplicationContext(), "String from file is: " + r,
        Toast.LENGTH_LONG).show();  
   }
};
task.execute();