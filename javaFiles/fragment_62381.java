// Select nodes with mass 2.5, follow edges with both conditions fulfilled and check that the children on these edges have no attributes. 
    Visitor v = QueryBuilder
                  .selectNodes(ConditionFactory.hasMass(2.5))
                  .withEdges(ConditionFactory.and(ConditionFactory.freestyle("att1 > 12"), ConditionFactory.freestyle("att2 > 23")) 
                  .withChildren(ConditionFactory.noAttributes())
                  .buildVisitor();