try {
    textarea.append("Copying " + sourceFile.getAbsolutePath()
                    + "   to " + targetFile.getAbsolutePath());
    is = new BufferedInputStream(new FileInputStream(sourceFile));
    bos = new BufferedOutputStream(new FileOutputStream(targetFile));

    long fileBytes = sourceFile.length();
    long soFar = 0;

    int theByte;

    while ((theByte = bis.read()) != -1) {
        bos.write(theByte);

        setProgress((int) (copiedBytes++ * 100 / totalBytes));
        publish((int) (soFar++ * 100 / fileBytes));
    }

    // Not required, finally will take care of it...
    //bis.close();
    //bos.close();
    publish(100);
    // !! THIS IS VERY, VERY NAUGHTY !!
    textarea.append(" Done!\n");
} catch (Exception excep) {

    JOptionPane.showMessageDialog(null, "The Server is not accessible or it may be down because of Network Issue", "ERROR", JOptionPane.ERROR_MESSAGE);
    task.cancel(true);

} finally {

    try {
        // techniqually, this gets taken care of when you close the stream,
        // but I tend not to trust it either...
        bos.flush();
    } catch (Exception e) {
    }

    try {
        bis.close();
    } catch (Exception e) {
    }
    try {
        bos.close();
    } catch (Exception e) {
    }

}