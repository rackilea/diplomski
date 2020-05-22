import groovy.lang.Binding;
import groovy.lang.Closure;
import groovy.lang.Script;
import java.util.Date;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.codehaus.groovy.runtime.callsite.CallSite;

public class version extends Script {
    public version() {
        CallSite[] var1 = $getCallSiteArray();
        super();
    }

    public version(Binding context) {
        CallSite[] var2 = $getCallSiteArray();
        super(context);
    }

    public static void main(String... args) {
        CallSite[] var1 = $getCallSiteArray();
        var1[0].call(InvokerHelper.class, version.class, args);
    }

    public Object run() {
        CallSite[] var1 = $getCallSiteArray();
        final class _run_closure1 extends Closure implements GeneratedClosure {
            public _run_closure1(Object _thisObject) {
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

        Object dateInternal = var1[1].call(new _run_closure1(this));
        return dateInternal;
    }

    public Object date() {
        CallSite[] var1 = $getCallSiteArray();
        return var1[2].callCurrent(this);
    }
}