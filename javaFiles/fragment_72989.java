private void testVector(){

    Vector v1 = new Vector(); // v1 references some vector created on the heap
    Vector v2 = new Vector(); 

    v1.add("1"); // vector referenced by v1 gets a "1" added
    v2.add(v1); // make v2[0] the second referrer to that Vector you created

    v1 = new Vector(); // Change what v1 refers to, this is not the same as destroying the original Vector
    // v2[0] still holds a reference to the original vector

    Vector v3 = (Vector)v2.get(0); // v3 is now another referrer to the same vector
    System.out.println(v3.elementAt(0));
}