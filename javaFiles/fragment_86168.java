String[] filePaths = {
        "euro/football/france/winners.txt",   //linux path
        "euro\\football\\france\\winners.txt" //windows path
};
for (String filePath : filePaths) {
    String[] values = filePath.split("[/\\\\]");
    System.out.println(Arrays.toString(values));
}