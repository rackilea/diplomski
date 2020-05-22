Collections.sort(l,new Comparator<MyLink>(){

    @Override
    public int compare(MyLink o1, MyLink o2) {
        int result = o1.last.compareTo(o2.last);
        if(result==0){
            result=o1.first.compareTo(o2.first);
        }
        return result;
    }
});