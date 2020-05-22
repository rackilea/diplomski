List<?> l1 = new ArrayList <String> ();
List<?> l2 = new ArrayList <Integer> ();
l1.addAll (l2); // this doesn't pass compilation, since you can't add Integer elements to
                // a List<String>

List<?> l1 = new ArrayList <String> ();
List<?> l2 = new ArrayList <String> ();
l1.addAll (l2); // this doesn't pass compilation too, since the compiler doesn't know that
                // l1 and l2 will refer to Lists of the same element type when addAll is 
                // invoked