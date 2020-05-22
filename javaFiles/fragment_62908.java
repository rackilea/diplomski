String[] fileArray;
fileArray = new String[8];

fileArray[0] = "/Downloads/file1.csv";
fileArray[1] = "/Downloads/file2.csv";
fileArray[2] = "/Downloads/file3.csv";
fileArray[3] = "/Downloads/file4.csv";
fileArray[4] = "/Downloads/file5.csv";
fileArray[5] = "/Downloads/file6.csv";
fileArray[6] = "/Downloads/file7.csv";
fileArray[7] = "/Downloads/file8.csv";

String home = System.getProperty("user.home");


for (String filePath: fileArray) {
    File file = new File(home + filePath); 
    System.out.println(filePath);
    if (file.exists()) {
        file.delete();
        System.out.println("Deleted");
    } else {
        System.out.println("failed");
        Assert.fail();
    }
}