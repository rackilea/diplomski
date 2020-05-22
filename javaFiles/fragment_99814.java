URL url = new URL(jobpayGrade);
    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
    connection.setRequestMethod("GET");
    connection.connect();

    int code = connection.getResponseCode();
    if(code==200){
        //set visible
    }else if(code==404){
        //set not visible
    }