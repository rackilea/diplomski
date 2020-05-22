static URL URLofString(String s){
 URL r=null;
 try { 
   r= new URL("http://stackoverflow.com");  
  } catch (MalformedURLException e) { } 
  return r;
 }