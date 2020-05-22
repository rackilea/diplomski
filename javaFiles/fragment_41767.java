package com.mycompany.util.configuration;

import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.StringRefAddr;
import javax.naming.spi.ObjectFactory;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class CustomDataSourceFactory extends BasicDataSourceFactory implements ObjectFactory {

    private static final Pattern _propRefPattern = Pattern.compile("\\$\\{.*?\\}");

    //http://tomcat.apache.org/tomcat-6.0-doc/jndi-resources-howto.html#Adding_Custom_Resource_Factories
    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable environment) throws Exception {
        if (obj instanceof Reference) {
            Reference ref = (Reference) obj;
            System.out.println("Resolving context reference values dynamically");

            for(int i = 0; i < ref.size(); i++) {
                RefAddr addr = ref.get(i);
                String tag = addr.getType();
                String value = (String) addr.getContent();

                Matcher matcher = _propRefPattern.matcher(value);
                if (matcher.find()) {
                    String resolvedValue = resolve(value);
                    System.out.println("Resolved " + value + " to " + resolvedValue);
                    ref.remove(i);
                    ref.add(i, new StringRefAddr(tag, resolvedValue));
                }
            }
        }
        // Return the customized instance
        return super.getObjectInstance(obj, name, nameCtx, environment);
    }

    private String resolve(String value) {
        //Given the placeholder, do stuff to figure out what it's true value should be, and return that String.
        //This could be decryption, or maybe using a properties file.
    }
}