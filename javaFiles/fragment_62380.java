Visitor v = QueryBuilder
                  .selectNodes(ConditionFactory.hasMass(2.5))
                  .withChildren(ConditionFactory.noAttributes())
                  .buildVisitor();
    node.accept(v);
    List<Set<Node>> validPaths = v.getValidPaths();