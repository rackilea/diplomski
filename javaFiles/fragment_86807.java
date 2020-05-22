@Entity
public class MutuallyExclusive1 {
    @Id
    @GeneratedValue
    private int Id;
    private String strValue;
    @Enumerated(EnumType.STRING)
    private MyEnum enumValue;

    public MutuallyExclusive1() {
        // do nothing
    }

    public void setEnum(final MyEnum enumValue) {
        if (strValue != null) {
            throw new IllegalStateException("stgValue and enumValue cannot be populated at the same time!");
        }
        this.enumValue = enumValue;
    }

    public void setString(final String strValue) {
        if (enumValue != null) {
            throw new IllegalStateException("stgValue and enumValue cannot be populated at the same time!");
        }
        this.strValue = strValue;
    }
}