List<Number> listNumber_ListNumber  = new ArrayList<Number>();
//List<Number> listNumber_ListInteger = new ArrayList<Integer>();                    // error - can assign only exactly <Number>
//List<Number> listNumber_ListDouble  = new ArrayList<Double>();                     // error - can assign only exactly <Number>

  List<? extends Number> listExtendsNumber_ListNumber  = new ArrayList<Number>();
  List<? extends Number> listExtendsNumber_ListInteger = new ArrayList<Integer>();
  List<? extends Number> listExtendsNumber_ListDouble  = new ArrayList<Double>();

  List<? super Number> listSuperNumber_ListNumber  = new ArrayList<Number>();
//List<? super Number> listSuperNumber_ListInteger = new ArrayList<Integer>();      // error - Integer is not superclass of Number
//List<? super Number> listSuperNumber_ListDouble  = new ArrayList<Double>();       // error - Double is not superclass of Number


//List<Integer> listInteger_ListNumber  = new ArrayList<Number>();                  // error - can assign only exactly <Integer>
  List<Integer> listInteger_ListInteger = new ArrayList<Integer>();
//List<Integer> listInteger_ListDouble  = new ArrayList<Double>();                  // error - can assign only exactly <Integer>

//List<? extends Integer> listExtendsInteger_ListNumber  = new ArrayList<Number>(); // error - Number is not a subclass of Integer
  List<? extends Integer> listExtendsInteger_ListInteger = new ArrayList<Integer>();
//List<? extends Integer> listExtendsInteger_ListDouble  = new ArrayList<Double>(); // error - Double is not a subclass of Integer

  List<? super Integer> listSuperInteger_ListNumber  = new ArrayList<Number>();
  List<? super Integer> listSuperInteger_ListInteger = new ArrayList<Integer>();
//List<? super Integer> listSuperInteger_ListDouble  = new ArrayList<Double>();     // error - Double is not a superclass of Integer


  listNumber_ListNumber.add(3);             // ok - allowed to add Integer to exactly List<Number>

  // These next 3 are compile errors for the same reason:
  // You don't know what kind of List<T> is really
  // being referenced - it may not be able to hold an Integer.
  // You can't add anything (not Object, Number, Integer,
  // nor Double) to List<? extends Number>      
//listExtendsNumber_ListNumber.add(3);     // error - can't add Integer to *possible* List<Double>, even though it is really List<Number>
//listExtendsNumber_ListInteger.add(3);    // error - can't add Integer to *possible* List<Double>, even though it is really List<Integer>
//listExtendsNumber_ListDouble.add(3);     // error - can't add Integer to *possible* List<Double>, especially since it is really List<Double>

  listSuperNumber_ListNumber.add(3);       // ok - allowed to add Integer to List<Number> or List<Object>

  listInteger_ListInteger.add(3);          // ok - allowed to add Integer to exactly List<Integer> (duh)

  // This fails for same reason above - you can't
  // guarantee what kind of List the var is really
  // pointing to
//listExtendsInteger_ListInteger.add(3);   // error - can't add Integer to *possible* List<X> that is only allowed to hold X's

  listSuperInteger_ListNumber.add(3);      // ok - allowed to add Integer to List<Integer>, List<Number>, or List<Object>
  listSuperInteger_ListInteger.add(3);     // ok - allowed to add Integer to List<Integer>, List<Number>, or List<Object>