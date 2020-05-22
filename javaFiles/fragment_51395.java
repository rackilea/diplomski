import java.io.IOException;
import java.io.Writer;
import java.util.*;

import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;


/** This outputter prints each attributes in a new line */
public class OneAttributePerLineOutputter extends XMLOutputter {

    // ----------------------------------------------------
    // Attribute
    // ----------------------------------------------------

    /** Limit wrapping attribute for one namespace */
    String namespace = null;

    /** Number of inline attributes before wrapping */
    private int nbInlineAttribs;

    // ----------------------------------------------------
    // Constructor
    // ----------------------------------------------------

    /**
     * @param namespace Limit wrapping attributes to one namespace. If null, all attributes are concerned
     * @param nbInlineAttribs Allow a given number of inline elements before wrapping to several lines 
     */
    public OneAttributePerLineOutputter(
            String namespace,
            int nbInlineAttribs) 
    {
        this.namespace = namespace;
        this.nbInlineAttribs = nbInlineAttribs;
    }

    // ----------------------------------------------------
    // Helpers
    // ----------------------------------------------------

    static private int elementDepth(Element element) {
        int result = 0;
        while(element != null) {
            result++;
            element = element.getParentElement();
        }
        return result;
    }

    // ----------------------------------------------------
    // Overridden methods
    // ----------------------------------------------------

    @Override protected void printAttributes(
            Writer writer, 
            List attribs, 
            Element parent,
            NamespaceStack ns) throws IOException 
    {       
                    // Loop on attributes
            for (Object attribObj : attribs) {

                Attribute attrib = (Attribute) attribObj;

                // Check namespace
                if ((this.namespace == null) || 
                    (this.namespace.equals(attrib.getNamespaceURI()))) 
                {   
                    // Reached max number of inline attribs ? 
                    if (attribs.size() > this.nbInlineAttribs) {

                        // New line
                        writer.append("\n");

                        // Indent
                        for (int i=0; i < elementDepth(parent); i++) {
                            writer.append(this.getFormat().getIndent());
                        }
                    }
                }

                // Output single atribute 
                List list = new ArrayList<Object>();
                list.add(attrib);
                super.printAttributes(writer, list, parent, ns);
            }
    }
}