ArrayList<BooleanWrap> temp=new ArrayList <BooleanWrap>(48); 
//cycle: operations to fill the ArrayList, then a condition is satisfied 

hashMap.put(index, temp);

//After that, I have to reuse the temp variable, so I need to reinitialize it. 
// I do it with the following instructions:

temp = new ArrayList <BooleanWrap>(48); 
//cycle: operations to fill the ArrayList