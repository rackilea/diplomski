package com.mycompany.datamodel;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PropOrderTest {

    @Parameter
    public Class clazz;

    @Parameters(name = "Test @XmlType.propOrder: {0}")
    public static Collection<Class> data() throws IOException {
        ClassPath classPath = ClassPath.from(Thread.currentThread().getContextClassLoader());
        String packageName = PropOrderTest.class.getPackage().getName();
        Set<ClassInfo> allClasses = classPath.getTopLevelClassesRecursive(packageName);
        List<Class> annotatedClasses = new ArrayList<Class>();
        for (ClassInfo info : allClasses) {
            Class clazz = info.load();
            if (clazz.isAnnotationPresent(XmlType.class)) {
                annotatedClasses.add(clazz);
            }
        }
        return annotatedClasses;
    }

    @Test
    public void testPropOder() throws IOException {
        XmlType xmlType = (XmlType) clazz.getAnnotation(XmlType.class);
        Set<String> propOrder = new HashSet<String>(Arrays.asList(xmlType.propOrder()));
        // remove empty string returned when propOrder is not declared
        propOrder.remove("");
        List<String> fieldNames = getFieldNames();
        propOrder.removeAll(fieldNames);

        assertTrue(formatMessage(propOrder), propOrder.isEmpty());

    }

    private List<String> getFieldNames() {
        Field[] fields = clazz.getDeclaredFields();
        List<String> names = new ArrayList<String>(fields.length);
        for (Field field : fields) {
            names.add(field.getName());
        }
        return names;
    }

    private String formatMessage(Collection<String> propOrder) {
        String message = null;
        String props = "'" + StringUtils.join(propOrder.toArray(), "', '") + "'";
        if (propOrder.size() > 1) {
            message = "Properties %s appear in @XmlType.propOrder, but no such properties exist in class %s (%s.java:1).";
        } else {
            message = "Property %s appears in @XmlType.propOrder, but no such property exists in class %s (%s.java:1).";
        }
        return String.format(message, props, clazz.getName(), clazz.getSimpleName());
    }
}