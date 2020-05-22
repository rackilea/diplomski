import java.io.StringWriter;
import java.util.*;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stu {

  public static void main(String[] argv) {
    VelocityEngine ve = new VelocityEngine();
    Properties p = new Properties();
    p.setProperty("resource.loader", "file");
    p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
    p.setProperty("file.resource.loader.path", "***INSERT TEMPLATEDIR***");
    p.setProperty("file.resource.loader.cache", "false");
    p.setProperty("file.resource.loader.modificationCheckInterval", "0");
    ve.init(p);
    @SuppressWarnings("rawtypes")
    ArrayList list = new ArrayList();

    Map map = new HashMap();
    map.put("rno", "2");
    map.put("name", "Komal");
    map.put("cla", "Bca");
    list.add(map);

    VelocityContext context = new VelocityContext();
    context.put("stuDetails", list);

    Template t = ve.getTemplate("stu.vm");
    StringWriter writer = new StringWriter();
    t.merge(context, writer);

    System.out.println(writer);
  }
}