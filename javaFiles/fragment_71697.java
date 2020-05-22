//try to find any movie that suits two predicates, 1st - that it's price is greater than 30( this is random number, you can put a value from your textfield here ) and 2nd - that it's title contains Spiderman ( again, put a value from your textfield title search here for your need )
   Optional<Film> movie = listOfMovies.stream().filter(i -> i.getPrice() > 30 && i.getTitle.contains("Spiderman")).findAny();
  // if any movie has been found to suits provided criterias
   if(movie.isPresent())
       {
               //print it on screen, note method get()
               //again this is just for example here, in your code,
               // you can do with this result whatever you like
               // for example show all data about that movie on screen    
               System.out.println("---->" +movie.get());
       }
      else
       {
              // if not found do nothing
              System.out.println("Nothing found...");
       }