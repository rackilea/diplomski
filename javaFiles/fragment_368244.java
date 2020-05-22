private void updateSharks() { 
    ArrayList<Shark> toRemove = new ArrayList<Shark>();
    ArrayList<Shark> toAdd = new ArrayList<Shark>();

    for(Iterator<Shark> sharkit = sharks.iterator(); sharkit.hasNext();) {
        Shark sharky = sharkit.next();
        if(sharky.hasStarved()) {
            toRemove.add(sharky);
        }
        else if(sharky.canBreed()) {
            toAdd.add(/*create new shark object here*/)
        }
        moveShark(sharky);
    }

    for (Shark shark : toRemove) {
        sharks.remove(shark);
    }
    for (Shark shark: toAdd) {
        sharks.add(shark);
    }
}