File makeMe = new File(folder);
int index = 0;
String master = folder;
while (makeMe.exists()) {
    folder = master + (++index);
    makeMe = new File(folder);
}