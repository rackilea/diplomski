if(null != ManualList && ManualList.size() >= ManualChoice &&
          ManualList.get(ManualChoice).status.equalsIgnoreCase(status2) ){
for (int i = 0; i < ManualList.size(); i++)
    if(borrowedManuals.size() > i)  // check borrowedManuals size its better to check this in if where you check for ManualList 
       System.out.println(borrowedManuals.get(i).displayManual());
       returnManualTitle = Console.readString(Messages.enterManualTitle, Messages.tooShortMessage, 3);
    }
 }