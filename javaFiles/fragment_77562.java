List<Integer> integers = new LinkedList<Integer>();

List <?> a = integers;
List <? extends Object> b = integers;
List <? super Object> c = new LinkedList<Object>();

//INVALID.  T maps to a type that could be Object OR anything else.  "Hello"
//would only be type-assignable to T if T represented String, Object, CharSequence,
//Serializable, or Comparable
abc(a, "Hello");

//INVALID.  T maps to a type that could be Object OR anything else.  "Hello"
//would only be type-assignable to T if T represented String, Object, CharSequence,
//Serializable, or Comparable
abc(b, "Hello");

//VALID.  T maps to an unknown super type of Object (which can only be Object itself)
//since String is already type-assignable to Object, it is of course guaranteed to be 
//type-assignable to any of Object's super types. 
abc(c, "Hello");

Integer i1 = integers.get(0);
Integer i2 = integers.get(1);