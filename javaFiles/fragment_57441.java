package xsom.test

import com.sun.xml.xsom.parser.XSOMParser;
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSContentType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSTerm;

import java.util.Iterator;
import java.io.File;
import java.util.HashMap;

public class mappingGenerator
{
  private HashMap mappings;

  public mappingGenerator()
  {
    mappings = new HashMap();
  }

  public void generate(String xmlfile) throws Exception
  {

    // with help from
    // http://msdn.microsoft.com/en-us/library/ms187822.aspx
    // http://it.toolbox.com/blogs/enterprise-web-solutions/parsing-an-xsd-schema-in-java-32565
    // http://www.w3schools.com/schema/el_simpleContent.asp
    XSOMParser parser = new XSOMParser();

    parser.parse(new File(xmlfile));
    XSSchemaSet sset = parser.getResult();

    // =========================================================
    // types namepace
    XSSchema gtypesSchema = sset.getSchema("http://www.btec.com/gtypes");
    Iterator<XSComplexType> ctiter = gtypesSchema.iterateComplexTypes();
    while (ctiter.hasNext())
    {
      XSComplexType ct = (XSComplexType) ctiter.next();
      String typeName = ct.getName();
      // these are extensions so look at the base type to see what it is
      String baseTypeName = ct.getBaseType().getName();
      System.out.println(typeName + " is a " + baseTypeName);
    }

    // =========================================================
    // global namespace
    XSSchema globalSchema = sset.getSchema("");
    // local definitions of enums are in complex types
    ctiter = globalSchema.iterateComplexTypes();
    while (ctiter.hasNext())
    {
      XSComplexType ct = (XSComplexType) ctiter.next();
      String typeName = ct.getName();
      String baseTypeName = ct.getBaseType().getName();
      System.out.println(typeName + " is a " + baseTypeName);
    }

    // =========================================================
    // the main entity of this file is in the Elements
    // there should only be one!
    if (globalSchema.getElementDecls().size() != 1)
    {
      throw new Exception("Should be only elment type per file.");
    }

    XSElementDecl ed = globalSchema.getElementDecls().values()
        .toArray(new XSElementDecl[0])[0];
    String entityType = ed.getName();
    XSContentType xsContentType = ed.getType().asComplexType().getContentType();
    XSParticle particle = xsContentType.asParticle();
    if (particle != null)
    {

      XSTerm term = particle.getTerm();
      if (term.isModelGroup())
      {
        XSModelGroup xsModelGroup = term.asModelGroup();
        term.asElementDecl();
        XSParticle[] particles = xsModelGroup.getChildren();
        String propertyName = null;
        String propertyType = null;
        XSParticle pp =particles[0];
        for (XSParticle p : particles)
        {
          XSTerm pterm = p.getTerm();
          if (pterm.isElementDecl())
          {            
            propertyName = pterm.asElementDecl().getName();
            if (pterm.asElementDecl().getType().getName() == null)
            {
              propertyType = pterm.asElementDecl().getType().getBaseType().getName();
            }
            else
            {
              propertyType = pterm.asElementDecl().getType().getName();              
            }
            System.out.println(propertyName + " is a " + propertyType);
          }
        }
      }
    }
    return;
  }
}