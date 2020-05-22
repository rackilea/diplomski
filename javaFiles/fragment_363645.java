InputStream is=null;
 if(respCode==200){
    is = con.getInputStream();                    
 } else if (urlConnection.getErrorStream() != null) {
    is = con.getErrorStream();
 }