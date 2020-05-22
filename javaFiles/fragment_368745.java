Iterator<MediaItem> it = items.iterator();
  while(it.hasNext())
  {
     MediaItem mi = it.next();
     if(mi.getTitle().equals(title))
     {
       mi.setLoanedTo(name);
       mi.setDateLoaned(date);
     }

  }