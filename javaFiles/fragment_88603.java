public static void createArmy(int units, int knights, int generals, int doctors){
   Unit unit = new Unit[units];
   Knight knight = new Knights[knights];
   General general = new Generals[generals];
   Doctor doctor = new Doctors[doctors];
   for(int x = 0; x < units;x++){
       unit[x] = new Unit("U"+(x+1));
   }
   for(int x = 0; x < knights;x++){
       knight[x] = new Knight("K"+(x+1));
   }
   for(int x = 0; x < generals;x++){
      general[x] = new General("G"+(x+1));
   }
   for(int x = 0; x < doctors;x++){
      doctor[x] = new Doctor("D"+(x+1));
   }
}