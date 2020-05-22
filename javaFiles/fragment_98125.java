try {
     URL myURL = new URL("http://test.com/");
     URLConnection myURLConnection = myURL.openConnection();
     myURLConnection.connect(); 
}  catch (MalformedURLException e) {  }  
catch (IOException e) {    //end test }