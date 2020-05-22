public boolean equals(Object other){
    if (other instanceof SingularNode<?>){
        if ( ((SingularNode<?>)other).value.equals(value) ){
            return true;
        }
    }
    return false;
}