public RDFNode getProperty(Resource subject,Property prop)
   {
   RDFNode object=null;
   StmtIterator iter2 = this.onto.model.listStatements(subject,prop,(RDFNode)null);  
    while (iter2.hasNext()) {
         object = iter2.nextStatement().getObject();
         break;
    }}
   iter2.close();
   return object;
   }

public String getPropertyAsString(Resource subject,Property prop)
   {
   RDFNode object=getProperty(subject,prop);
   return object==null?null:object.toString();
   }

(...)
String s1=getPropertyAsString(P,onto.hasFirstName);
String s2=getPropertyAsString(P,onto.hasLastName);
(...)