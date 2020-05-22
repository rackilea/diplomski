File f = new File("./data/account");
if(!f.getParentFile().exists()) { // if the directories don't exist
    if(!f.getParentFile().mkdirs()) { // if making the directories fails
        // directories weren't created, throw exception or something
    }
}
f.createNewFile();