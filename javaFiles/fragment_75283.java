interface IVisitor{
    void visit( Fragment1 f ); // <- These correspond to your "if instanceof" - branches
    void visit( Fragment2 f );
    void visit( Fragment3 f );
}

interface IVisitable{
     void accept( IVisitor visitor );
}