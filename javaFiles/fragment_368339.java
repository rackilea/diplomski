String AppPath = System.getProperty("user.dir");
String fileName = "Surabhi.txt";
File f = new File(AppPath, fileName); //f.getAbsolutePath() will give the concatenated name
if(f.exists()) {
    //Whatever
}