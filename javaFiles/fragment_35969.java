VIPGuest vg = (VIPGuest) g;
writer.write(g.getGuestID() + "," + 
             g.getFName() + "," + 
             g.getLName() + "," +
             g.getDateJoin() + "," + 
             vg.getVIPstartDate() + "," + 
             vg.getVIPexpiryDate());