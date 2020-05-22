//Creates a new reference to the object passed in, v1
Vector temp = v1;
//Sets the reference v1 to point to a new object, which will not affect the originals
v1 = new Vector();
for(int i = 0; i<v2.size(); i++)
    //adds the contents of v2 into the new object
    //This has no impact on the original objects
    v1.add(v2.get(i));
for(int j = 0; j< temp.size(); j++)
    //adds the contents of what was passed in as v1 into v2
    v2.add(temp.get(j));