public void addName(String sName){
    for (int i = 0; i < name.length; i++) {
        if (name[i] == null) {
            name[i] = sName;
            break;
        }
    }
}