public boolean isIdentical(Tree t2){
       Tree t1 = this;
       return isIdentical(t1, t2);
    }

    private boolean isIdentical(Tree t1, Tree t2){
    if(t1 == t2)
        return true;
    if(t1==null || t2==null)
        return false;
    return (
        (t1.data == t2.data) &&
        (isIdentical(t1.left, t2.left)) &&
        (isIdentical(t1.right, t2.right))
    );

}