public static <T> void eachExceptLast(List<? extends T> list, Operation<T> op) {
     Iterator<T> iter = list.iterator();
     if (!iter.hasNext()) {
         return;
     }
     T item = iter.next();
     while (iter.hasNext()) {
         op.run(item);
         item = iter.next();
     }
}