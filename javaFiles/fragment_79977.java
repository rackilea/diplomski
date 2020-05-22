// I left out getters and setters for brevity.
 class PersonNode {
      Person current;
      PersonNode next;
      PersonNode previous;
 }

 class PersonList {
       PersonNode head; 
       PersonNode tail;

      public PersonList(){ 
          head.previous = null;
          tail.next = null;
      }
      void addFront(Person p){ 
          if (head.person == null) {
                head.person = p; 
          }
          else {
               PersonNode temp = head; head= new PersonNode(p);               
               temp.previous = head; head.next = temp;
               }
          }
     void addBack(Person p) {
          if (tail.person == null) {
                tail.person = p; 
          }
          else {
              PersonNode temp = tail;
              tail= new PersonNode(p);               
              temp.next = tail;
              tail.previous = temp;
      }

     int count() {
          int c = 0;
          for(PersonNode n = head; head.next != null; n = head.next){
              if (n.Person !=null){
                  ++c;
              }
          }
          return c;
     }
}