package sumit2;

import org.mozilla.javascript.ScriptableObject;
public class Sumit extends ScriptableObject {
    public String getClassName(){
        return "Sumit";
    }   
    public void foo() {
        System.out.println("Sumit!!!!!!!");
    }
    @Override
    public Object getDefaultValue(Class<?> typeHint) {
        return toString();
    }

}