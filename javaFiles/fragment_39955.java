import javax.management.MBeanException;
import javax.management.ReflectionException;

import com.sun.management.DiagnosticCommandMBean;

import sun.management.ManagementFactoryHelper;

@SuppressWarnings("restriction")
public class ClassHistogram {

    public static void main(String[] args) throws MBeanException, ReflectionException {
        DiagnosticCommandMBean dcmd = ManagementFactoryHelper.getDiagnosticCommandMBean();

        String[] emptyStringArgs = {};
        Object[] dcmdArgs = { emptyStringArgs };
        String[] signature = { String[].class.getName() };
        System.out.println(dcmd.invoke("gcClassHistogram", dcmdArgs, signature));
    }

}