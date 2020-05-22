public static void main(String args[]) {

    String fileNameStartsWith = "_pdfsam_pdf_";
    String dir = "D:\\files\\";
    String destDir = "D:\\dest\\";  
    int totalPages = 32;
    int loops = totalPages/2;
    boolean pickFirst = true;
    int pageNbr1 = 0;
    int pageNbr2 = 0;
    int count = 1;
    for(int i=1; i <= loops; i++) {
        if(pickFirst == true) {
            pageNbr1 = totalPages;
            pageNbr2 = i;
            pickFirst = false;

totalPages--;
        } else {
            pageNbr1 = i;
            pageNbr2 = totalPages;
            totalPages--;
            pickFirst = true;
        }           
        System.out.println("PageNbr 1 "+pageNbr1);
        System.out.println("PageNbr 2 "+pageNbr2);
        File dest = new File(destDir);
        dest.mkdirs();
        File file1 = new File(dir + pageNbr1+fileNameStartsWith+".pdf");            
        renameFile(file1, dir, count, fileNameStartsWith, destDir, pageNbr1);
        count++;
        File file2 = new File(dir + pageNbr2+fileNameStartsWith+".pdf");
        renameFile(file2, dir, count, fileNameStartsWith, destDir, pageNbr2);
        count++;

    }

}


public static void renameFile(File file, String dir, int count, String fileNameStartsWith, String destDir, int pageNbr) {
    boolean success = new File(dir + count+fileNameStartsWith+".pdf").renameTo(new File(destDir + pageNbr+fileNameStartsWith+"modified"+".pdf"));
    System.out.println("success2 : "+success);                      
}