public boolean contains(int n) {
    if (value == n){
        return true;
    }else if(next == null){
        return false;
    }
    return next.contains(n);
}