//lists all the files ending with -release in the etc folder
File dir = new File("/etc/");
File fileList[] = new File[0];
if(dir.exists()){
    fileList =  dir.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String filename) {
            return filename.endsWith("-release");
        }
    });
}
//looks for the version file (not all linux distros)
File fileVersion = new File("/proc/version");
if(fileVersion.exists()){
    fileList = Arrays.copyOf(fileList,fileList.length+1);
    fileList[fileList.length-1] = fileVersion;
}       
//prints all the version-related files
for (File f : fileList) {
    try {
        BufferedReader myReader = new BufferedReader(new FileReader(f));
        String strLine = null;
        while ((strLine = myReader.readLine()) != null) {
            System.out.println(strLine);
        }
        myReader.close();
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}