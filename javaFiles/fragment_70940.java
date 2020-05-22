import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@FilterDef(name = "myFilter", parameters = @ParamDef(name = "nameParameter", type = "string"))
@Table(name = "accounts")
public class Account {
...