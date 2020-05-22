final String ORDER= "FCBWHJLOAQUXMPVINTKGZERDYS";

Arrays.sort(str, new Comparator<String>() {

    @Override
    public int compare(String o1, String o2) {
       return ORDER.indexOf(o1) -  ORDER.indexOf(o2) ;
    }
});