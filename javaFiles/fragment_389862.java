new Function<String, Integer> {
    @Override
    public Integer apply(String s){
        return Integer.getInteger(s);
    }
}