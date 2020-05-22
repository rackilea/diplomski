AND(){
    public Set operate(Set one, Set two){
        Set temp = new HashSet<Integer>(one);
        temp.retainAll(two);
        return temp;
    }
},

OR(){
    public Set operate(Set one, Set two){
        Set temp = new HashSet<Integer>(one);
        temp.addAll(two);
        return one;
    }
};