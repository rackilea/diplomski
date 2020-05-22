for(MediaItem mi : items)
  {
      if(mi.getTitle().equals(title))
     {
       mi.setLoanedTo(name);
       mi.setDateLoaned(date);
     }
  }