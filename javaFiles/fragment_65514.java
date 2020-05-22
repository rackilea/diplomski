String tmp = Beid.bid(); //big string with \n and hash picture:
  String[] output = tmp.split("picture:"); 
  tmp = output[0]; //how to avoid split picture:?

  tmp = tmp.replaceAll("(\r\n|\n)", "<br/>");
  sendMessage("{\"msg\" : \"" + tmp + "\"}");