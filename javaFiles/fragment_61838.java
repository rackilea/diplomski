public int returnMaxChildren() {
    int count = children.size();
    for (Person child : children){
        int childMax = child.returnMaxChildren();
        if (childMax > count){
            count = childMax;
        }
    }
    return count;
}