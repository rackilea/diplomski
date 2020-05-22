Comparator<FOO> f1 = new Comparator<FOO>(){
    @Override
    public int compare(FOO lhs, FOO rhs) {          
        return lhs.f1.compareTo(rhs.f1);
    }
};

Comparator<FOO> f2 = new Comparator<FOO>(){
    @Override
    public int compare(FOO lhs, FOO rhs) {          
        return lhs.f2.compareTo(rhs.f2);
    }
};