class C implements Cloneable { 
    C copy() throws CloneNotSupportedException {
        return (C)clone();
    } 
}
class D extends C implements Cloneable { 
    D copy() throws CloneNotSupportedException {
        return (D)clone();
    } 
}