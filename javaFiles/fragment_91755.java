import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Stream;

public class FunctionalSequence<T> implements Iterable<T>{
    LinkedList<CountedFlighweight<T>> realList = new LinkedList<>();
    StackOverflowingFunction<Integer, T> calculate = null;
    public FunctionalSequence<T> initialize(Stream<T> start){
        start.forEachOrdered((T value) ->
        {
                realList.add(new CountedFlighweight<>());
                realList.getLast().set(value);
        });
        return this;
    }
    public FunctionalSequence<T>  setSequenceFunction(StackOverflowingFunction<Integer, T> calculate){
        this.calculate = calculate;
        return this;
    }

    @Override
    public Iterator<T> iterator() {
        return new SequenceIterator();
    }
    public T get(int currentIndex) throws StackOverflowError{
        if(currentIndex < 0) return null;
        while (currentIndex >= realList.size()){
            realList.add(new CountedFlighweight<T>());
        }
        try {
            return (T) realList.get(currentIndex).get(calculate, currentIndex);
        } catch (Exception e) {
            return null;
        }
    }
    public class SequenceIterator implements Iterator<T>{
        int currentIndex;
        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public T next() {
            T result = null;
            if (currentIndex == realList.size()){
                realList.add(new CountedFlighweight<T>());
            }
            // here the StackOverflowError catching is a pure formality, by next() we would never cause StackOverflow
            try {
                result = realList.get(currentIndex).get(calculate, currentIndex);
            } catch (StackOverflowError e) {
            }
            currentIndex++;
            return result;
        }

    }
    /**
     * if known is false, the value of reference is irrelevant
     * if known is true, and reference is not null, reference contains the data
     * if known is true, and reference is null, that means, that the appropriate data are corrupted in any way
     * calculation on corrupted data should result in corrupted data.
     * @author Pet
     *
     * @param <U>
     */
    public class CountedFlighweight<U>{
        private boolean known = false;
        private U reference;
        /**
         * used for initial values setting 
         */
        private void set(U value){
            reference = value;
            known = true;
        }
        /**
         * used for data retrieval or function counting and data saving if necessary
         * @param calculate
         * @param index
         * @return
         * @throws Exception
         */
        public U get(StackOverflowingFunction<Integer, U> calculate, int index) throws StackOverflowError{
            if (! known){
                if(calculate == null) {
                    reference = null;
                } else {
                    try {
                        reference = calculate.apply(index);
                    } catch (Exception e) {
                        reference = null;
                    }
                }
            }
            known = true;
            return reference;
        }
    }

    @FunctionalInterface
    public interface StackOverflowingFunction <K, U> {
        public U apply(K index) throws StackOverflowError;

    }
}