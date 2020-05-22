String MainUrl;
urlInput = urlInput.toLowerCase();
String hostName = urlInput;
String[] suburls = hostName.split("\\."); 
MainUrl=suburl[0]
if(suburls[0].contains("www'){  
    MainUrl=suburl[1];
  }
if(MainUrl.contains("http://"))
     MainUrl.replace("http://","");
else if(MainUrl.contains("https://")
    MainUrl.replace("https://","");