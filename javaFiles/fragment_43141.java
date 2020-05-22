class Paragens{
   List<Rota> existEnRota = new ArrayList<Rota>();


   public void addRota(Rota r){
       existEnRota.add(0, r);
   }
}