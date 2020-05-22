YourForm uploadForm = (YourForm) form;
FormFile file = null;
try {
    file = uploadForm.getFile();
    //FormFile#getFileData() returns the byte array containing the file data
    //You can use it to save the file in your database and other things you want/need
    int id = 9001; //assuming this is a valid id in the mensaje table
    MensajeService mensajeService = new MensajeService();
    mensajeService.saveFile(id, file.getFileData());
} catch (Exception e) {
    //log the errors for maintenance purposes (bugs, fixes, etc) 
}