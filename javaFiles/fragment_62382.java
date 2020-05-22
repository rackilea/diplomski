public interface QueryBuilder {
         QuerySelector selectNodes(Condition c);
         QuerySelector allNodes();
    }

    public interface QuerySelector {
         QuerySelector withEdges(Condition c);
         QuerySelector withChildren(Condition c);
         QuerySelector withHyperChildren(Condition c);
         // ...
         QuerySelector and(QuerySelector... selectors);
         QuerySelector or(QuerySelector... selectors);

         Visitor buildVisitor();
    }