private boolean isAscending(String left, String right){
    // if either parameter is null, then not ascending
    if(left == null || right == null) return false;

    return (left.compareToIgnoreCase(right) > 0);
}