public boolean check(Depot [] depots, String name){
      boolean check = false;
      for (int i = 0; i < depots.length; i++){
          if(depots[i].getDepotName().equals(name))
         return true;
        }
      return check;

     }