@Aspect
public class DataSourceAspect {
    @AfterReturning(value = "execution(* javax.sql.DataSource.getConnection(..))", 
        returning = "c")
    public void afterGetConnection(Connection c) {
        ...
    }
}