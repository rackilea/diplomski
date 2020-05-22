public void download(String urlToDownload){

URLConnection urlConnection = null;

try{

    URL url = new URL(urlToDownload);

    //Opening connection of currrent url

    urlConnection = url.openConnection();
    urlConnection.connect();

    //int lenghtOfFile = urlConnection.getContentLength();


String PATH = Environment.getExternalStorageDirectory() + "/1/";

File file = new File(PATH);
file.mkdirs();
File outputFile = new File(file, "file.mp3");
FileOutputStream fos = new FileOutputStream(outputFile);

InputStream is = url.openStream();


byte[] buffer = new byte[1024];

int len1 = 0;

while ((len1 = is.read(buffer)) != -1) {
    fos.write(buffer, 0, len1);
}

fos.close();
is.close();

System.out.println("downloaded"+urlToDownload);

}catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();

}

}