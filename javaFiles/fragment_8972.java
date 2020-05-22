public boolean collidesWith(ICollider otherObj) {
    GameObject gObj = (GameObject) otherObj;
    //this collider
    int r1 = (int) (getX() + getWidth()/2);
    int l1 = (int) (getX() - getWidth()/2);
    int t1 = (int) (getY() + getHeight()/2);
    int b1 = (int) (getY() - getHeight()/2);

    //the other collider
    int r2 = (int) (gObj.getX() + gObj.getWidth()/2);
    int l2 = (int) (gObj.getX() - gObj.getWidth()/2);
    int t2 = (int) (gObj.getY() + gObj.getHeight()/2);
    int b2 = (int) (gObj.getY() - gObj.getHeight()/2);

    if (r1 < l2 || l1 > r2 || t1 < b2 || b1 > t2)
       return false;
    else
       return true;

    /* Or could be shortened down to
    return !(r1 < l2 || l1 > r2 || t1 < b2 || b1 > t2) */

}