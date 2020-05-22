List<Integer> nthElement( List<Integer> dims, int n ){
    List<Integer> res = new ArrayList<Integer>(dims.size());
    for(Integer cur  : dims){
        if(n <= 0 ){
            res.add(0);
        } else {
            n -= cur;
            res.add(n >= 0 ? cur -1  : cur + n );
        }
    }
    return res;
}