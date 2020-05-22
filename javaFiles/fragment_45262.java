int chosen = 0;
    int left = oneHundredInactiveSynapses.size();
    java.util.Random rand = new java.util.Random();
    for (Synapse inactiveSynapse : oneHundredInactiveSynapses) {
        if(left-chosen>21) inactiveSynapse.setActiveState(true);
        else{
          if(rand.nextBoolean()){
            inactiveSynapse.setActiveState(true);
            chosen++;
            if(chosen==21) break;
          }
        }
        left--;
   }