1.new DataLink<>(new Link())
2.this(value, new Link(false));  
    3.protected Link(boolean b) {    //from new Link(false)
          this(99); 
    4. this.myId = myId;  // myId = 99, from this(99)
5.super(parent); //calling public Link(Link next)
6.this.next = next; //next = link object with myId=99