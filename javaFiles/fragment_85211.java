for(custom p : data) {
   List<custom> l = map.get(p.getUser());
   if(l == null){
       l = new ArrayList<>();
       map.put(p.getUser(), l);
   }
   l.add(p);
}