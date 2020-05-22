Child child = new Child();
// Show the variable name of the class Child
System.out.println(child.name);
// Show the variable name of the class Parent which is what this.name 
// does in the getName method
System.out.println(((Parent)child).name);