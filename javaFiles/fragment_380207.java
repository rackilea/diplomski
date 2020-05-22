@XmlRootElement
public class Results {

    @XmlElement
    Result result;

    public Result getResult() {
        return result;
    }
}

public class Result {
    @XmlElement
    Binding binding;

    public Binding getBinding() {
        return binding;
    }
}

public class Binding {
    @XmlElement
    Double literal;

    public Double getLiteral() {
        return literal;
    }
}