@Entity
public class MyEntity {

    @Embedded
    public StringTuple tuple;

}

public class StringTuple {
    public String s1;
    public String s2;
}