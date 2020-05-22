public void enqueue(Dog aDog)
     {
         Node dogNode = new Node(aDog);

         counter++;
         if (front == null)
             front = back = dogNode;
         else
         {
             back.nextNode = dogNode;
             back = dogNode;

         }
     }
  public Node dequeue()      
  {
      if(front == null) return null;
      Dog firstDog = front ;
      front = front.nextNode;
      counter--;
      return firstDog;
  }