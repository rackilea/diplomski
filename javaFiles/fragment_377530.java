@Embeddable
public class IssTESTPK implements Serializable {

    // Ops... Our missing field which causes our Exception (repeated column... blah, blah, blah...)
    @Column(name="SURVEY_NUM", nullable=false)
    private Integer property;

    private Integer otherProperty;

    private Integer anotherProperty;

    // required no-arg constructor
    public IssTESTPK() {}

    // You must implement equals and hashcode
    public boolean equals(Object o) {
        if(o == null)
            return false;

        if(!(o instanceof IssTESTPK))
            return false;

        IssTESTPK other = (IssTESTPK) o;
        if(!(getProperty().equals(other.getProperty())))
            return false;
        if(!(getOtherProperty().equals(other.getOtherProperty())))
            return false;
        if(!(getAnotherProperty().equals(other.getAnotherProperty())))
            return false;

        return true;
    }

    // NetBeans or Eclipse will worry about it
    public int hashcode() {
        // hashcode code goes here
    }

}