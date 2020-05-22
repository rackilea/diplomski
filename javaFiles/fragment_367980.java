import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class Admin {

    @Getter
    @Setter
    public long id;
    @Getter
    @Setter
    public String email;
    @Getter
    @Setter
    public String password;
    @Getter
    @Setter
    public boolean rememberme;
    @Getter
    @Setter
    public String salt;
    @Getter
    @Setter
    public Date created;

    public Admin() {

    }
}