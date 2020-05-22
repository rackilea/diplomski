public boolean add(item value) {
if(this == value) {
    return false
} else if(this.left < value) {
    if(this.left != null) {
        return this.left.add(value)
    } else {
        this.left = new Node(value)
        return true
    }
} else { //if(this.right > value)
    if(this.right != null) {
        return this.right.add(value)
    } else {
        this.right = new Node(value)
        return true
    }
}
}