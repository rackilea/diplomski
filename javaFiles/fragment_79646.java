@Override
public String toString() {

    if(this.left==null&&this.right != null){
        return this.value.toString()+" " + this.right.toString();
    } 
    if(this.left!=null&&this.right == null){
        return  this.left.toString() +" " + this.value.toString();
    } 

    if(this.left !=null && this.right != null)
    return this.left.toString()
                +" " +this.value.toString()+" "  + this.right.toString();
    return this.value.toString();
}