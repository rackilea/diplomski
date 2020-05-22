public void add(String element)
  {
      Node newNode = new Node(element);
      if (isEmpty()) 
      {
          first = newNode;
          last = newNode;
      }
      else if (element.compareTo(first.value) < 0)//if element is lesser than all elements in list
      {
         newNode.next = first;
         first= newNode;
      }
      else
      {
        Node after = first.next;
        Node before = first;
        while (after != null)// finding exact position to insert
        {
            if (element.compareTo(after.value) < 0)
                break;
            before = after;
            after = after.next;
        }
        // insert between before & after
        newNode.next = before.next;
        before.next = newNode;
      }

  }