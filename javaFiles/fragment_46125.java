void increasePriority(p) {
        if (priorities.hasKey(p)) { 
            priorities.put(p, priorities.get(p) + 1);
        } else {
            priorities.put(p, 1); 
        }    
    }

    void decreasePriority(p) {
        int count = priorities.get(p);
        if (count > 1) {  
            priorities.put(p, count - 1);
        } else {
            priorities.remove(p);
        }   
    }