public String isValidID(String id) {
     if(getId().length()!=6) {//checks for 6 digit id
         return "wrong";                        // <== Exits immediately if reached
     }
     else{//checks if digit contains invalid entry
        for(int i=0;i<getId().length();i++){
            if(Id.charAt(i)>'9'||Id.charAt(i)<'0')
                return "wrong";                 // <== Exits immediately if reached
            }
     }
     return "right";                            // <== Exits immediately if reached
                                                // (granted, we would have exited
                                                // below anyway :-) )
}