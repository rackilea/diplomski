//Define these classes. 

class A {} //It can be an abstract class as well.
class B extends A {}    

//Main code.
A b = new B();
System.out.println(b instanceof A); //prints true.