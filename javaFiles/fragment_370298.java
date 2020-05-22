/* Agent.java

javac -cp ".:$JAVA_HOME/lib/tools.jar" -d . Agent.java Test.java && \
jar cfm Agent.jar Agent-MANIFEST.MF mypackage/Agent.class

*/

package mypackage;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class Agent implements ClassFileTransformer {
    public static Instrumentation inst;

    public static void premain(String agentArgs, Instrumentation inst) {
        Agent.inst = inst;
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        Agent.inst = inst;
    }

    public byte[] transform(ClassLoader loader, String className, Class redefiningClass, ProtectionDomain domain, byte[] bytes) throws IllegalClassFormatException {
        /* returning null means we don't want to change a thing
        */
        return null;
    }
}