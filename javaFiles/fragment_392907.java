public static List<String> toList(String[] array) {
    if (array==null) {
       return new ArrayList(0);
    } else {
       int size = array.length;
       List<String> list = new ArrayList(size);
       for(int i = 0; i < size; i++) {
          list.add(array[i]);
       }
       return list;
    }
}