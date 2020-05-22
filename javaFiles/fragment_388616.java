// Create an assembly object to load our classes
Assembly testAssembly = Assembly.LoadFile(Application.StartUpPath + @"MyObjects.Person.dll");
Type objType = testAssembly.GetType("MyObjects.Person");

// Create an instace of MyObjects.Person
var instance = Activator.CreateInstance(objType);

// Call the method
string fullname = (string)calcType.InvokeMember("GetName",
BindingFlags.InvokeMethod | BindingFlags.Instance | BindingFlags.Public,
null, instance, null);