public boolean removeBoat(String boatId) {
    System.out.println(">>> Deleting boat.");
    Boat b = findBoatById(boatId);

    if( b != null ){
       this.dock.getDockedBoats().remove(b);
       return true;
    }

    return false;
}

public Boat findBoatById(String boatId) {
    System.out.println(">>> Find boat from list.");

    for( Boat b : this.dock.getDockedBoats() ){
       if( boatId.equalsIgnoreCase( b.boatId ) ){
          return b;
       } 
    }

    return null;
}