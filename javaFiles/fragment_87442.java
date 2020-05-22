String url = "https://www.gamezone.com/news/";
    Bundle mbundle = getIntent().getExtras();
     if(mbundle != null){
       String str = mbundle.getString("keytitle");
       url += str+"/";
       url = url.replaceAll(" ", "-");
    }