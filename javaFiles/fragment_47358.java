class XO {

   String name="-";
public void setName(String name){
    this.name=name;
}

public String getName(){
    return name;

}
public boolean equals(XO x1, XO x2){
    return(x1.getName().equals(this.getName())&&x2.getName().equals(this.getName())&&this.getName()!="-");               
}

 @Override
 public String toString() {
     return getName();
 }