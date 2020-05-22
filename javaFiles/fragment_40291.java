for(int i=0;i<reminderSentList.size();i++)
   {
      Familyvisa familyVisa = service.findByForiegnKey_Family(reminderSentList.get(i).getIdFamily());
      familyVisa.setNumberOfReminders(familyVisa.getNumberOfReminders()+1);
      familyVisa.setLastReminderSent(Common.getCurrentDateSQL());
      visa.add(familyVisa);
   }