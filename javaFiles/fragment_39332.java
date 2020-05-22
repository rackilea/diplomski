Person = com.testpkg.Person;
MyParser = com.testpkg.MyParser;
var myObject = Person.getInstance("myObject");
myObject.id = 1;
myObject.string1 = "Hello";
myObject.string2 = "World";
myObject.string3 = "Another Test";
myObject.string4 = "Testing";
try
{
   var parser = new MyParser();
   var returnStr = parser.PrintObj(myObject);
}
catch (e)
{
   print("An error occured");
}