if (QueueArray[root].getF() > QueueArray[child].getF())
      {
         Vertex temp = QueueArray[root];
         QueueArray[root] = QueueArray[child];
         QueueArray[child] = temp;
         swapNodes(child);
      }