function jsFunction(a,s)
{
 //a - or a,b,c etc - here will be the "other" parameters
 //s - will be the instance of the Java side Storage class passed above
 //now you can do things like
 s.writeToFile('fileName','fileData');
 var fd = s.readFromFile('fileName');
 s.dropFile('fileName');
 ...
}