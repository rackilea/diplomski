package sumit2;

import jp.tonyu.js.BuiltinFunc;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
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

    @Override
    public Object get(String name, Scriptable start) {
        if ("foo".equals(name)) {
            return new Function() {

                @Override
                public Object call(Context cx, Scriptable scope, Scriptable thisObj,
                        Object[] args) {
                    foo();
                    return "Return value of foo";
                }
                /** ...Implement all methods of Function other than call **/

            };
        }
        return super.get(name, start);
    }


}