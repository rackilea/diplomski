Set<String> result = new TreeSet<String>(new Comparator<String>(){
    @Override
    public int compare(String arg0, String arg1) {
        return returnCode(arg0).compareTo(returnCode(arg1));
    }
 });