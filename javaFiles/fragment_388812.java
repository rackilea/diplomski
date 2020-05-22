for(Integer[] arr : allVariables) {
    for(Integer i : arr) {
        if(i != null && i.equals(searchValue)) return true;
    }
}
return false;