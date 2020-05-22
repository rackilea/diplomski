List<Dados> next = new ArrayList<Dados>();
for(Dados d : arrayWithData) {
   if(!next.isEmpty() && next.get(next.size() - 1).getId() != d.getId() - 1) {
      tmap.put(tmap_key++, next);
      next = new ArrayList<Dados>();
   }
   next.add(d);
}
if(!next.isEmpty()) {
   tmap.put(tmap_key++, next);
}