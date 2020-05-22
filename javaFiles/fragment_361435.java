import org.jdom.filter.Filter;
import org.jdom.Element;

public class ElementRegexFilter implements Filter {

    private String regex = "";

    public ElementRegexFilter( String regex )
    {
        this.regex = regex;
    }

    public boolean matches( Object o )
    {
        if( o instanceof Element )
        {
            String ElementName = ((Element) o).getName();
            return ElementName.matches( regex );
        }
        return false;
    }

}