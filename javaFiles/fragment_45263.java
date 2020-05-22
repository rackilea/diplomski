int count = 0;
   for(Synapse inactiveSynapse : oneHundredInactiveSynapses){
     if(count==21) break;
     inactiveSynapse.setActiveState(true);
     count++;

   }