1)  o = new Float();  
2)  oa = new Object[];  
    at this point we have 2 objects.  
3) oa[0] = o;  
    at this point oa[0] holds the reference of o.  
4)  o = null;  
    o is still being referenced by oa[0]  
5)  oa[0] = null  
    o now has zero references.  
6)  return o;  
     o is null.