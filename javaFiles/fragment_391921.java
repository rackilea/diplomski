UML                       Java
Dependency A->B           Class A mentions class B
Association A->B          Class A has reference {that can have reference} (it is recursive!} to class B
Composition A->B          Class A has array or collection of B or of references to B AND 
(black diamond)             no other classes have instances of B or references to them, 
                            either single or collective (arrays, collections)
Shared aggregation A->B   Class A has array or collection of B or of references to B AND 
(empty diamond)             at least one other class has an instance of B or references to such, 
                            either single or collective (arrays, collections)