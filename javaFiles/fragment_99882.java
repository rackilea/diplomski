FileOutputStream fOut = null;
//Since you are creating a subdirectory, you need to make sure it's there first
File directory = new File(Environment.getExternalStorageDirectory(), "AutoWriter");
if (!directory.exists()) {
    directory.mkdirs();
}

try {
    //Create the stream pointing at the file location
    fOut = new FileOutputStream(new File(directory, "samplefile.txt"));
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
OutputStreamWriter osw = new OutputStreamWriter(fOut);

//...etc...