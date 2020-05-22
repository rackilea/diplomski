private class AuthorList{
    private LinkedList<String> nameList;

    public AuthorList() {
    }

    public AuthorList(LinkedList<String> nameList) {
        this.nameList = nameList;
    }

    public LinkedList<String> getNameList() {
        return nameList;
    }

    public void setNameList(LinkedList<String> nameList) {
        this.nameList = nameList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AuthorList{");
        sb.append("nameList=").append(nameList);
        sb.append('}');
        return sb.toString();
    }
}