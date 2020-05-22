for(int i = 0; i < states.size(); i++) {
        if(map.get(i).isGoal()){
            //instantiate wherever you want if goal is true
            map.get(i).setGoal();
        } else {
            //instantiate wherever you want if goal is false
        }
    }