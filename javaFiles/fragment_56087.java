Collections.sort(items, new Comparator<MyModel>() {
   private List<String> order = Arrays.asList("B", "C", "A");

   @Override
     public int compare(MyModel item1, MyModel item2) {    
         return order.indexOf(item1.type) - order.indexOf(item2.type);
     }
});