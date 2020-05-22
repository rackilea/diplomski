Iterator itr = tasked.iterator(); 
    while(itr.hasNext()) {
        Villager e = itr.next();
        if(!e.hasTask()) {
           itr.remove();
        }
    }