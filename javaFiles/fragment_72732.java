void main(){

    List<String>[] array = new List[1];
    fill(array);

    // The compiler could not check the array at compile time, so
    // the next line is permitted. But you just created yourself a time bomb.
    List<String> list = array[0];

    // The next line will finally cause a ClassCastException at runtime!
    // Good luck with debugging, especially if you have passed your list
    // arround for a while.
    // If you had defined List<?>[] foo, this assignment would have been
    // forbidden without explicit casting to String. But at least the "type"
    // of the array did not make you false promises about the generic type
    // of the list.
    String value = list.get(0);
 }

 // This method receives an array of lists. At runtime the generic type of
 // the array is gone. Therefore, a call to this method can be called with
 // anz List<SomeType>[] array as an argument. 
 void fill(List<?>[] array) {
   List<Integer> list = new ArrayList<Integer>();
   list.add(123)
   array[0] = list;
 }