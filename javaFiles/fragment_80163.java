Example.java:8: error: method printNames in class Printer cannot be applied to given types;
        Printer.<Type> printNames(t1, t2, t3, "test");
               ^
  required: T[]
  found: Type,Type,Type,String
  reason: varargs mismatch; String cannot be converted to Type
  where T is a type-variable:
    T extends Type declared in method <T>printNames(T...)