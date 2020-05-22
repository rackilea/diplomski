File file = new File(mFileName + "/Recording (" + String.valueOf(entryNumber) + ")" + ".mp3");
if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
}