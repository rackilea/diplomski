private Set<Integer> intSet = new HashSet<Integer>();

public void setIntArray(Integer[] i){
    intSet = new HashSet<Integer>(Arrays.asList(i));
}

public Integer[] getIntArray(){
    return intSet.toArray(new Integer[0]);
}