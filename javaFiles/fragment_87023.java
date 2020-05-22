String filecontents = new String( java.nio.file.Files.readAllBytes(Paths.get(new File(name).toURI())));
    String contactinfostart = String.valueOf(other.getCount()); //First value in file
    String contactinfoend = other.getState();
    int contactstartindex = filecontents.indexOf(contactinfostart);
    int contactendindex = filecontents.indexOf(contactinfoend + other.getState().length());
    String prefix = filecontents.substring(contactstartindex);
    String ending = filecontents.substring(contactendindex);
    String newfilecontents = prefix + ending;
    rw.seek(0);
    rw.writeUTF(newfilecontents);