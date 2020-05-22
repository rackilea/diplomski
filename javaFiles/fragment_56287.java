String absolutePath = request.getServletContext().getRealPath("");
String savePath = appPath + File.separator + SAVE_DIRECTORY;

File imageSaveDirectory = new File(savePath);
if (!imageSaveDirectory.exists()) {
    imageSaveDirectory.mkdir();
}