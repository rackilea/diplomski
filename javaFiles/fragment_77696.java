public boolean contains(String id){
    for (MyDelayed md : DelayedIds){ 
        if(md.getMyId().equals(id)){
            return true;
        }
    }
    return false;
}