import java.util.AbstractList;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class User {
    public Iterable<Integer> mergeKSortedIterators(List<Iterator<Integer>> Iters){


        Queue<newIter> minHeap = new PriorityQueue<newIter>();
        AbstractList<Integer> result = new ArrayList<Integer>();
        for(Iterator<Integer> iter : Iters){
            if(iter.hasNext()){
                minHeap.add(new newIter(iter.next(), iter));
            }
        }

        while(!minHeap.isEmpty()){
            newIter newiter = minHeap.poll();
            result.add(newiter.getValue());
            if(newiter.hasNext()){
                minHeap.add(newiter);
            }
        }
        return result;
    }

    class newIter implements Comparable<newIter>{
        private Integer value;
        private Iterator<Integer> iter;
        public newIter(Integer val, Iterator<Integer> it){
            this.value = val;
            this.iter = it;
        }
        public Integer getValue(){
            return this.value;
        }
        public boolean hasNext(){
            if(iter.hasNext()){
                value = iter.next();
                return true;
            }
            return false;
        }

        public int compareTo(newIter a){
            return value - a.getValue();
        }
    }
}