public class CassandraService {
  //...

  public void run() {

    String id = "1";
    List<String> names = ['abc','xyz'];


    PreparedStatement selectStmt = session.prepare("SELECT id, name, value FROM table WHERE id=? AND name=?;");
    List statements = new ArrayList<Statement>();

    for(String name : names) {
      statements.add(selectStmt.bind(id,name));
    }

    Observable<Row> rows = execute(statements);

    //Do work with rows.
  }


  public Observable<ResultSet> executeAndReturnResultSet(Statement statement) {
    return Observable.from(session.executeAsync(statement));
  }


  public Observable<Row> execute(List<Statement> statements) {
    List<Observable<ResultSet>> resultSets = Lists.transform(statements, this::executeAndReturnResultSet);
    return Observable.merge(resultSets).flatMap(Observable::from);
  }
}