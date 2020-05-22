import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * User: alfasin
 * Date: 8/19/13
 */
@Root(name="KAMP",strict = false)
public class KAMP {

    @Element(name = "ID", required = false)
    public String Id;

    @Element(name = "SQLTID", required = false)
    public String Sqltid;

    @Element(name = "DATO", required = false)
    public String MatchDate;

}