public static void main (String[] args) 
{
    XMLCreater x = new XMLCreater();
    String[] s = {"A","B","C"};
    try 
    {
        x.CreateXMLDoc("k","root",s,s);
        x.CreateXMLDoc("k","root",s,s);
        x.CreateXMLDoc("fakih","root",s,s);
    }
    catch (TransformerConfigurationException exception) 
    { exception.printStackTrace(); }
}