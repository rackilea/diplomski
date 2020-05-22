class CustomeFilter implements FilenameFilter {

    @Override
    public boolean accept(File directory, String fileName) {
        boolean valid = false;
        //if (fileName.startsWith("j") ) 
        if ( fileName.endsWith(".mp3") || fileName.endsWith(".wav")) {

            valid = true;
        } else {
            valid = false;
        }

        return valid;
    }

}