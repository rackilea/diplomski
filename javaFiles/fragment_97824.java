public static <T> T[] addToArray(T item, T... items){
      T[] array;
      int array_size = 1;

      if(items !=null){ array_size = items.length+1; }

      array = java.util.Arrays.copyOf(items, array_size);
      array[array_size-1] = item;

      return array;
    }