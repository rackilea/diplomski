String source = "C:/your/source";
File srcDir = new File(source);

String destination = "C:/your/destination";
File destDir = new File(destination);

try {
    FileUtils.copyDirectory(srcDir, destDir);
} catch (IOException e) {
    e.printStackTrace();
}