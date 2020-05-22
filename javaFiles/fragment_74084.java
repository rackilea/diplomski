import org.stringtemplate.v4.*;
import net.sf.json.*;

class STExampleApp {

        public static void main(String args[]) {
                String template = "decl(type, name, value) ::= \"<type> <name><init(value)>;\"\n"
                                + "init(v) ::= \"<if(v)> = <v><endif>\"";
                STGroup views = new STGroupString(template);
                ST decl = views.getInstanceOf("decl");
                decl.add("type", "int");
                decl.add("name", "x");
                decl.add("value", 12);
                System.out.println(decl.render());
        }

}