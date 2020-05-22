private static final int BATCH_SIZE = 50;

public void addBatch(Connection connection, List<Outer> outers) {

  PreparedStatement outerInsertStatement = connection.prepareStatement("...", Statement.RETURN_GENERATED_KEYS);
  PreparedStatement innerInsertStatement = connection.prepareStatement("...", Statement.RETURN_GENERATED_KEYS);

  List<Integer> outerIds = new ArrayList<Integer>();

  for(Outer outer : outers) {
    outerInsertStatement.setParameter(...);
    ...
    outerInsertStatement.setParameter(...);

    outerInsertStatement.addBatch();
  }

  outerInsertStatement.executeBatch();
  //Note, this line requires JDBC3
  ResultSet primaryKeys = outerInsertStatement.getGeneratedKeys();
  while(!primaryKeys.isAfterLast()) {
    outerIds.add(primaryKeys.getInt(0));
  }

  for(int i = 0; i < outers.size(); i++) {
    Outer outer = outers.get(i);
    Integer outerId = outerIds.get(i);
    for(Inner inner : outer.getInners()) {
      //One of these setParameter calls would use outerId
      innerInsertStatement.setParameter(...);
      ...
      innerInsertStatement.setParameter(...);
      innerInsertStatement.addBatch();

      if( (i+1) % BATCH_SIZE == 0) {
        innerInsertStatement.executeBatch();
      }
    }
    innerInsertStatement.executeBatch();
  }
}