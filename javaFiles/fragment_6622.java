try {
     Process p = Runtime.getRuntime().exec(
                    new String[]{"cmd.exe", "/c", "F:/myprog/start.bat"});
     InputStream in = p.getInputStream();
     OutputStream out = p.outputStream();
} catch (IOException e){
     e.printStackTrace();
}