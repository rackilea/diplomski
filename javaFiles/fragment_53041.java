public void copyFileFromUrl(URL source, File target, int count) throws IOException {
try {

    if (!target.exists()) {

        target.createNewFile();
        log.debug("target file created for " + target);

        log.debug("downloading source ....");
        InputStream in = source.openStream();
        OutputStream out = new FileOutputStream(target);

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }

    } else {
        log.debug("skipping creation of asset");
    }

} catch (Exception e) {
    log.debug("trouble with " + target);
    if(count < 3){
        target.delete();
        copyFileFromUrl(source, target, count++);
    }
    // TODO Auto-generated catch block
    e.printStackTrace();
} finally {
    in.close();
    out.close();
}