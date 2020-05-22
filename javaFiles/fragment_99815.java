if(isValidURLConnection(jobpayGrade)){
    button.setVisible(true);
}else {
    button.setVisible(false);
}

private boolean isValidURLConnection(String jobPayGrade){
    URL url = null;
    try {
        url = new URL(jobPayGrade);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
    try {
        connection.setRequestMethod("GET");
        connection.connect();
        return connection.getResponseCode()==200;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}