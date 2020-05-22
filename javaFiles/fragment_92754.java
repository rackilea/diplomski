Pair p=new Pair(s,1); 
 Pair previous=d.find(p);
 if(previous!=null) {         
     previous.count++;
 } else {
     d.insert(p);
 }