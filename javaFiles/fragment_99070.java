public void saveCult(UUID u, String cult ) {
   Auth a= this.auth.get(u.toString());
   if(a != null) { //SHOULD always be true, but who knows?
     a.setCult(cult);
     this.auth.put(u.toString(), a);
   }
}