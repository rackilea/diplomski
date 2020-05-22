@Override
 protected String doInBackground(String... params) {
      String info=null;
      try {
          Document doc = Jsoup.connect(links).get();
          info = doc.select("div.col-1-1 article p").text();
         } catch (Exception e) {
             e.printStacktrace();     
         }
    return info;
 }