File localFile = new File("/path/XYZ-17012013.pdf");
FileOutputStream fout = new FileOutputStream(localFile);

boolean success = fTPClient.retrieveFile(ftpServerFilePath, fout);

if (success) {
    fout.flush();
    fout.close();
} else {
    System.out.println("Retrieve failure");
}