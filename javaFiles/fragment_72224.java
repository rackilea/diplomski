class KeyWordedArrayList<T> extends ArrayList<T>{
    private final String keyword;

    public KeyWordedArrayList(String keyword){
        this.keyword = keyword;
    }

    public String getKeyword(){
        return keyword;
    }
}