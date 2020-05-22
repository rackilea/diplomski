@Entity
public class MutuallyExclusive2 {
    @Id
    @GeneratedValue
    private int Id;
    private String strValue;
    @Enumerated(EnumType.STRING)
    private MyEnum enumValue;

    public MutuallyExclusive2() {
        // do nothing
    }

    public void setEnum(final MyEnum enumValue) {
        this.strValue = null;
        this.enumValue = enumValue;
    }

    public void setString(final String strValue) {
        this.enumValue = null;
        this.strValue = strValue;
    }
}