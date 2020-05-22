MyClass c1 = getAnotherInstance();
MyClass c2 = getAnotherInstance();

c1.value     // The field "value" for "c1" contains 10.
c2.value     // The field "value" for "c2" contains 12.
             // Because "c1" and "c2" are different instances, and 
             // "value" is an instance field, they can contain different
             // values.