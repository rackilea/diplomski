try {   
    FileService fileService = new FileService();
   FileList files = fileService.getPublicFiles(null);
    if(files != null && ! files.isEmpty()) {
        for (File file : files) {
            out.println("<a href=\"" + file.getDownloadLink() + "\"> " + file.getLabel() + "</a><br/>" );
        }
    } else {
    out.println("No Results");
    }
} catch (Throwable e) {}