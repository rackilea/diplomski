File myCSVFile; //reference to your file here 
String execString = "excel " + myCSVFile.getAbsolutePath();
Runtime run = Runtime.getRuntime();
try {
    Process pp = run.exec(execString);
} catch(Exception e) {
    e.printStackTrace();
}