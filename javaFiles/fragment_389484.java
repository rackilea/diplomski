String userAgent=req.getHeader("user-agent");
  String browserName = "";
  String  browserVer = "";
  if(userAgent.contains("Chrome")){ //checking if Chrome
        String substring=userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0];
        browserName=substring.split("/")[0];
        browserVer=substring.split("/")[1];
    }
    else if(userAgent.contains("Firefox")){  //Checking if Firefox
        String substring=userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0];
        browserName=substring.split("/")[0];
        browserVer=substring.split("/")[1];
    }