//... we are in Fragment1
public void accept( IVisitor visitor ){ 
    visitor.visit(this); /* Dispatch #2 just callback into visitor, 
                          * will automatically call the correct 
                          * visit( x ) impl. in Activity.*/
}