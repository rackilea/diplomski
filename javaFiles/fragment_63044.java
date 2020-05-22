/***Initialize an instance of Class A with the properties that you want to match***/
A instanceA = new A();
instanceA.setProperty1("wwww");
instanceA.setProperty2("xxxx"); 
Example exampleA = Example.create(instanceA);

/***Do the same for the Class B**/
B instanceB = new B();
instanceB.setProperty1("yyyy");
instanceB.setProperty2("zzzz"); 
Example exampleB = Example.create(instanceB);

/**Create and execute the QBE***/
List<A> results = session.createCriteria(A.class)
    .add(exampleA)
    .createCriteria("b",CriteriaSpecification.LEFT_JOIN) // b is the property of Class A
    .add(exampleB)
    .list();