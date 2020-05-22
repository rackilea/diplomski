// XXX More pseudo code in Java than actual code ... (this is untested)
fileList = Gdx.files.internal("levels.txt");
String files[] = fileList.readString().split("\\n");
for (String filename: files) {
   FileHandle fh = Gdx.files.internal("levels/" + filename);
   ...
}