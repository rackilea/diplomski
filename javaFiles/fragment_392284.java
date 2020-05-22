import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.File;
import java.util.List;

/**
 * User: alfasin
 * Date: 8/19/13
 */
@Root(name="ALL")
public class ALL {

    @ElementList(entry="KAMP", inline=true)
    private List<KAMP> kamp;

    public ALL(){};

    public List<KAMP>  getMatches() {
        return kamp;
    }

    public static void main(String...args) throws Exception {
        Serializer serializer = new Persister();
        File example = new File("/Users/alfasin/Documents/workspace-sts-3.2.0.RELEASE/SimpleXML/src/kamp.xml");
        ALL all = serializer.read(ALL.class, example);
        for(KAMP tmp : all.getMatches()){
            System.out.println("ID: "+tmp.Id);
            System.out.println("MatchDate: "+tmp.MatchDate);
            System.out.println("Sqltid: "+tmp.Sqltid);
            System.out.println("----------");
        }
    }
}