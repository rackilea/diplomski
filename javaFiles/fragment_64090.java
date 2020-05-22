right.head = nextOfMiddle;
            right.num_nodes = totalSize - newSize;
            //Create the left list, firstly by creating an empty shell and replace the head node
            BasicLinkedList<Integer> left = new BasicLinkedList();
            left.head = original.head;

            //here is the mistake
            //change it to  - left.num_nodes = newSize;
            right.num_nodes = newSize;