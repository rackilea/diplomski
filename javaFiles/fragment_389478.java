public class MyQueue<T> extends ArrayDeque<T>{
    public void reverse() {
      T[] contents = toArray(T[]);
      clear();

      if(contents != null){
        for(int i = contents.length-1; i >= 0; i--){
            add(contents[i]);
        }
      }
  }
}