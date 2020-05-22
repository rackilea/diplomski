synchronized(this) {
    available.get(id).acquire();                                            
    available.get(id+1).acquire();                                         
}

synchronized(this) {
   available.get(id).release();                                            
   available.get(id+1).release(); 
}