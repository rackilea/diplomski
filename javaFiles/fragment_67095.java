Collections.sort(list, new Comparator<String>(){
    @Overide
    public int compare(String s1, String s2){
        return s1.split(";")[1].compareTo(s2.split(";")[1]);
    }
});