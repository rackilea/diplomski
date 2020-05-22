import com.example.demo.Base64Encoded;

public class MyRequest {

    private String varA;

    @Base64Encoded
    private B varB;

    public String getVarA() {
        return varA;
    }

    public void setVarA(String varA) {
        this.varA = varA;
    }

    public B getVarB() {
        return varB;
    }

    public void setVarB(B varB) {
        this.varB = varB;
    }
}