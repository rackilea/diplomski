@Override
public String toString() {

    if(this.left==null&&this.right != null){
        return this.value.toString()+" " + this.right.toString();
    } 
    if(this.left!=null&&this.right == null){
        return this.value.toString()+" " + this.left.toString();
    } 

    if(this.left !=null && this.right != null)
    return this.value.toString()+" " + this.left.toString()
                +" " + this.right.toString();
    return this.value.toString();;
}