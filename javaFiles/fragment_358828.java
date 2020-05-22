private static void addDataAList(AuthorList[] aL, String iN) {
    int index = Character.toUpperCase(iN.trim().charAt(0)) - 'A';
    try {
        AuthorList tmpAuthorList = aL[index];
        if(tmpAuthorList == null) aL[index] = tmpAuthorList = new AuthorList(new LinkedList<>());
        if(tmpAuthorList.getNameList() == null) tmpAuthorList.setNameList(new LinkedList<>());
        tmpAuthorList.getNameList().add(iN);
    } catch (ArrayIndexOutOfBoundsException aioobe){
        throw new IllegalArgumentException("Name should start with character A - Z");
    }
}