int index = -1;
 for (int i=0; i<teams.length; i++){                    
     total[i] = 2*wins[i]+ties[i]; 
     if (total[i] > peak) {
        index = i;
        peak = total[i];
     }
     System.out.println(teams[i]+" - " + wins[i] + " wins, " + losses[i] + " 
   losses, " + ties[i] + " ties = " + total[i]);
 }