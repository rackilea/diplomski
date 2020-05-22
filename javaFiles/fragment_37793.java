private MyObjectType findNode(final PropertyEn propertyEn) {
    return myNestedTree.visitChildren(Node.class, new IVisitor<Node<MyObjectType>, MyObjectType>() {

        @Override
        public void component(Node<MyObjectType> object, IVisit<MyObjectType> visit) {
        if ( object.getModelObject().getPropertyEn() == propertyEn ) {
            visit.stop(object.getModelObject());
        }
    }
)};