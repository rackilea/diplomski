int maxRange = 100;

File makeMe = new File(folder);
int index = 0;
String master = folder;
while (makeMe.exists() && index < maxRange) {
    makeMe = new File(master + (++index));
}

if (index > maxRange) { // || makeMe.exists()
    throw new IOException("Could not find free directory");
} else {
    // All happy unicorns...
}