Class SomePackage.JavaTest Extends %Persistent
{

Method JavaTestyTest() As %String [ Language = java, WebMethod ]
{
    string tmp = "Hello World";
    return tmp;
}
Method bleh() as %Library.String
{
    q "bleh"
}
Projection NewProjection1 As %Projection.Java(ROOTDIR = "C:\trans");

}