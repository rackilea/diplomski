import java.io.IOException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

public class App
{
    public static void main(String[] args) throws IOException, NamingException
    {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
        InitialDirContext idc = new InitialDirContext(env);

        String ipAddr = "74.125.225.196";

        // Turn the IP into an in-addr.arpa name
        // 196.225.125.74.in-addr.arpa.
        String[] quads = ipAddr.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = quads.length - 1; i >= 0; i--) 
        {
            sb.append(quads[i]).append(".");
        }
        sb.append("in-addr.arpa.");
        ipAddr = sb.toString();

        Attributes attrs = idc.getAttributes(ipAddr, new String[] {"PTR"});
        Attribute attr = attrs.get("PTR");

        if (attr != null) 
        {
            for (int i = 0; i < attr.size(); i++)
            {
                System.out.println((String)attr.get(i));
            }
        }
    }  
}