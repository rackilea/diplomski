package xxx.readers;

public class MyReader  extends  JdbcCursorItemReader<AnObjet> implements InitializingBean{


@Override
public void afterPropertiesSet() throws Exception {
        // set the SQL

    String SELECT_PAYMENT = "SELECT * from table"
    super.setSql(SELECT_PAYMENT);

    }
}