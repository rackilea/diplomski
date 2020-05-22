Node<Integer>[] intNodeArray = ...;
Object[] objArray = intNodeArray; //legal because arrays are covariant
objArray[0] = new Node<String>("asfd"); //should fail but doesn't

...

//sometime later
Node<Integer> intNode = intNodeArray[0]; //still doesn't fail because of erasure
Integer i = intNode.getValue(); //only now do we get a runtime exception