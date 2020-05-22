public class BaseClassAdapter {

    private final BaseClass baseClass;
    private final Token token;

    public BaseClassAdapter(BaseClass baseClass){ 
       this.baseClass = baseClass;
       this.token = ...;
    }

    public Result mothodA(String arg1, String arg2) {
       baseClass.mothodA(token, arg1, arg2);
    }

    ...
}