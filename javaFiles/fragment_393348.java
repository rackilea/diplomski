for (Player player1 : players){ // For each player
  // first of all you need to move the initialization for highest and highest1 INSIDE the
  // for loop to use the proper highest values at each iteration
  // With your current code the lists highestlist and highestlis1 each have
  // ONE Player object which is empty (because in the default constructor 
  // of Player you do nothing), you then use the empty initial Player in each list to
  // compare the vote count, this will mostly result in the first if  
  // clause(playerCount > highest) being triggered,
  // which will add the initial empty Player object to highestlist1
  int highest = highestList.size() == 0 ? -1 : highestList.get(0).getCount();// if the list is empty initialize it with -1 to signal the first player handled
  int highest1 = highestList1.size() == 0 ? -1 : highestList1.get(0).getCount();

  int playerCount = player1.getCount(); // Get his votes

    // you need to check for -1 to handle the case when you're dealing 
    // with the first player( which of course will have the highest 
    // count as there's no either player to compare it yet)
    if(playerCount > highest || highest == -1){ // If they're the highest so far, add it to the 1st list
        highestList1.addAll(highestList);
        highestList.clear();
        highestList.add(player1);
        // the same for highest1
    } else if (playerCount > highest1 || highest1 == -1){ // If they're the 2nd highest so far, add it to the 2nd list
        highestList1.clear();
        highestList1.add(player1);
    }else if(playerCount == highest){ // If they're equal to the current highest one, add it to the 1st list as well
        highestList1.add(player1);
    } else if (playerCount == highest1){ // If they're equal to the current 2nd highest one, add it to the 2nd list as well
        highestList1.add(player1);
    }