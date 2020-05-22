import groovy.lang.Binding;
import groovy.lang.Closure;
import groovy.lang.Script;
import java.util.Date;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;

public class version extends Script {
    Object dateInternal;

    public version() {
        CallSite[] var1 = $getCallSiteArray();
        super();
        Object var2 = var1[0].call(new version._closure1(this));
        this.dateInternal = var2;
    }

    public version(Binding context) {
        CallSite[] var2 = $getCallSiteArray();
        super(context);
        Object var3 = var2[1].call(new version._closure1(this));
        this.dateInternal = var3;
    }

    public static void main(String... args) {
        CallSite[] var1 = $getCallSiteArray();
        var1[2].call(InvokerHelper.class, version.class, args);
    }

    public Object run() {
        CallSite[] var1 = $getCallSiteArray();
        return null;
    }

    public Object date() {
        CallSite[] var1 = $getCallSiteArray();
        return ScriptBytecodeAdapter.invokeClosure(this.dateInternal, new Object[0]);
    }

    public final class _closure1 extends Closure implements GeneratedClosure {
        public _closure1(Object _thisObject) {
            CallSite[] var3 = $getCallSiteArray();
            super(version.this, _thisObject);
        }

        public Object doCall(Object it) {
            CallSite[] var2 = $getCallSiteArray();
            return var2[0].call(var2[1].callConstructor(Date.class), "yy.Mdd.Hmm");
        }

        public Object doCall() {
            CallSite[] var1 = $getCallSiteArray();
            return this.doCall((Object)null);
        }
    }
}