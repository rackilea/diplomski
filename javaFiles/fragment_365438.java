public boolean searchForExit(Location myLocation){
    if(location.isFinish()){
        location.setSolutionPath(true);
        return true;
    }
    location.setVisited(true);
    for(Location location : location.getNeighbours()){
        if(!location.isVisited()){
            if (searchForExit(location)){
                location.setSolutionPath(true);
                return true;
            }
        }
    }
    return false;
}