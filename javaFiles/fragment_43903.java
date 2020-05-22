class Query {
   private SelectClause select;
   private FromClause  from;
   private WhereClause where;
   private Limit        limit;
}

class SelectClause {
   private List<String> fields;
}
...
class WhereClause {
   Condition root;
}

interface Condition {
...
}

class AndCondition implements Condition { // the same for Not, Or

}