ArrayList<ObjectA> objA = new ArrayList()<>;
objA.add( new ObjectA() );  
objA.add( new ObjectAB() ); // ObjectAB extends ObjectA

ObjectAB ab = (ObjectAB) objA.get(1);
ab.setFieldFromAB("foo");