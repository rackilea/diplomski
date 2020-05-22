Session session = ...
try {

  for(int i=0;i<reminderSentList.size();i++)
    {
        /* findByForiegnKey_Family() has Session argument now! */
        Familyvisa familyVisa = service.findByForiegnKey_Family(session, reminderSentList.get(i).getIdFamily());
        familyVisa.setNumberOfReminders(familyVisa.getNumberOfReminders()+1);
        familyVisa.setLastReminderSent(Common.getCurrentDateSQL());
        visa.add(familyVisa);
    } 
  } catch (Exception ex) {
      System.out.println("ERROR:"+ex);
  } finally {
      session.close();
  }