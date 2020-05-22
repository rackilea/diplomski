public int kthSmallest(PriorityQueue<Integer> pQ, int k) {
    if(k <= 0 || k > pQ.size()) {
           throw new IllegalArgumentException();
    } else {
         Queue<Integer> aux = new ArrayDeque<Integer>();
         int kThSmallest = -1;
         for(int c=0;c<pQ.size();c++){
               Integer element = pQ.remove();
               if(c == k-1) 
                   kThSmallest = element;
               aux.add(element);
          }
          while(!aux.isEmpty())
              pQ.add(aux.remove());
         return kThSmallest;
      }
}