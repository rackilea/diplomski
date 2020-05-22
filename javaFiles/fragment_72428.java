for(File f: filesFromDirectory) {
    bool OK = true;
    for(Long i: fnameVals) {
        if(f.name.contains(String.valueOf(i))) {
            OK = false;
            break;
    }
    if(OK) System.out.println(f.name);
}