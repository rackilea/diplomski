import static org.objectweb.asm.Opcodes.*;
import java.util.*;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

/* ... */

final String fqcn = "com.example.MyAnnotation";
final String methodName = "strlen";
final String methodDesc = "(Ljava/lang/String;)I"; // int function(String)

ClassNode cn = new ClassNode(ASM6);
cn.version = V1_8; // Java 8
cn.access = ACC_SYNTHETIC | ACC_PUBLIC | ACC_INTERFACE | ACC_ABSTRACT | ACC_ANNOTATION;
cn.name = fqcn.replace(".", "/");
cn.superName = "java/lang/Object";
cn.interfaces = Arrays.asList("java/lang/annotation/Annotation");

// String value();
cn.methods.add(
    new MethodNode(
        ASM6, ACC_PUBLIC | ACC_ABSTRACT, "value", "()Ljava.lang.String;", null, null));