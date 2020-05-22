protected LinkedList<ConcordanceDataElement>[] hashtable;


public ConcordanceDataStructure(int i) {

   this.size=fourKPrime(i);
   @SuppressWarnings("unchecked")
   this.hashtable=new LinkedList[this.size];


}

protected int getTableSize() {
  return this.hashtable.length;
}

public void add(String term, int lineNum){ 
    boolean noError;
    boolean hit = false;
    int pass, q, offset, ip;
    int pk = Math.abs(term.toLowerCase().hashCode()); // preprocess the key
    if (nodes<=getTableSize())// insert the node
    { 
        pass = 0;
        q = pk / getTableSize();
        offset = q;
        ip = pk % getTableSize();
        if(q%getTableSize() == 0)
            offset = 9967;
    }
    else
    {
        System.out.println("FULL");
        return;
    }
    while(pass < getTableSize())
    { 
        if(hashtable[ip] == null){  // no more problems
            hit = true;
            break;
        }
        ip = (ip + offset)%getTableSize();
        pass = pass +1;
    }