@NamedStoredProcedureQuery(
    name="getUsers", 
    procedureName="get_users", 
    resultClass=User.class, parameters={
        @StoredProcedureParameter(queryParameter="data", name="data", direction=Direction.OUT_CURSOR)
    }
)
@Entity
public class User {
    ...
}