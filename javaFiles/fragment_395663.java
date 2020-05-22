package dbank.so;

import java.io.File;

import org.apache.xerces.xs.XSFacet;
import org.apache.xerces.xs.XSImplementation;
import org.apache.xerces.xs.XSLoader;
import org.apache.xerces.xs.XSModel;
import org.apache.xerces.xs.XSObject;
import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSSimpleTypeDefinition;
import org.apache.xerces.xs.XSTypeDefinition;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;

public class XSLoaderTest {

    public static void main(String[] args) {
        System.setProperty(DOMImplementationRegistry.PROPERTY, "org.apache.xerces.dom.DOMXSImplementationSourceImpl");
        DOMImplementationRegistry registry;
        try {
            registry = DOMImplementationRegistry.newInstance();
            XSImplementation impl = (XSImplementation) registry.getDOMImplementation("XS-Loader");

            XSLoader schemaLoader = impl.createXSLoader(null);
            XSModel xsModel = schemaLoader.loadURI(new File("form1.xsd").toURI().toString());
            XSTypeDefinition xsTypeDef = xsModel.getTypeDefinition("myDefinedType", null);
            if(xsTypeDef.getTypeCategory() == XSTypeDefinition.SIMPLE_TYPE) {
                XSSimpleTypeDefinition xsSimpleType = (XSSimpleTypeDefinition) xsTypeDef;

                //get just maxInclusive
                XSObject maxIncObj = xsSimpleType.getFacet(XSSimpleTypeDefinition.FACET_MAXINCLUSIVE);
                if(maxIncObj != null) {
                    XSFacet maxIncFacet = (XSFacet) maxIncObj;
                    System.out.println("myDefinedType's maxInclusive: "+maxIncFacet.getLexicalFacetValue()+"\n");
                }

                //get all facets (except enumeration and pattern facets, which don't exist in this schema example anyway)
                XSObjectList facetList = xsSimpleType.getFacets();
                System.out.println("myDefinedType's facets:  ");
                for(int i = 0; i < facetList.getLength(); ++i) {
                    XSFacet facet = (XSFacet) facetList.get(i);
                    System.out.println("  "+facetKindToString(facet.getFacetKind())+": "+facet.getLexicalFacetValue());
                }
                //if you had a schema with enumeration and pattern facets and you wanted their information, you would use xsSimpleType.getMultiValueFacets()
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException e) {
            //handle exception
        }
    }

    //a simple utility method to give a String representation of the facetKind
    private static String facetKindToString(short facetKind) {
        switch(facetKind) {
            case XSSimpleTypeDefinition.FACET_NONE: return "none";
            case XSSimpleTypeDefinition.FACET_LENGTH: return "length";
            case XSSimpleTypeDefinition.FACET_MINLENGTH: return "minLength";
            case XSSimpleTypeDefinition.FACET_MAXLENGTH: return "maxLength";
            case XSSimpleTypeDefinition.FACET_PATTERN: return "pattern";
            case XSSimpleTypeDefinition.FACET_WHITESPACE: return "whitespace";
            case XSSimpleTypeDefinition.FACET_MAXINCLUSIVE: return "maxInclusive";
            case XSSimpleTypeDefinition.FACET_MAXEXCLUSIVE: return "maxExclusive";
            case XSSimpleTypeDefinition.FACET_MINEXCLUSIVE: return "minExclusive";
            case XSSimpleTypeDefinition.FACET_MININCLUSIVE: return "minInclusive";
            case XSSimpleTypeDefinition.FACET_TOTALDIGITS: return "totalDigits";
            case XSSimpleTypeDefinition.FACET_FRACTIONDIGITS: return "fractionDigits";
            case XSSimpleTypeDefinition.FACET_ENUMERATION: return "enumeration";
            default: return "unknown facet kind";
        }
    }

}