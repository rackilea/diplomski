import com.sun.codemodel.CodeWriter;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import com.sun.codemodel.writer.SingleStreamCodeWriter;

public class CreateGenericMethodTest
{
    public static void main(String[] args) throws Exception
    {
        JCodeModel codeModel = new JCodeModel();
        JPackage jpackage = codeModel._package("com.example");
        JDefinedClass jclass = jpackage._class("Example");

        JType genericType = codeModel.directClass("T");
        JMethod jmethod =
            jclass.method(JMod.PUBLIC | JMod.STATIC, genericType, "get");
        jmethod.generify("T", Number.class);
        JClass parameterType = codeModel.ref(Class.class).narrow(genericType);
        jmethod.param(parameterType, "type");

        jmethod.body()._return(JExpr.ref("null"));
        CodeWriter codeWriter = new SingleStreamCodeWriter(System.out);
        codeModel.build(codeWriter);
    }
}