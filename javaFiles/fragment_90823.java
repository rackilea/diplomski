@Override
  public void done(List<ParseUser> parseUsers, ParseException e) {
          if (e==null) {
            // The query was successful.
          try{
               ParseUser user = parseUsers.get(0);
               String userId = user.getObjectId();
             }
       catch(ArrayIndexOutOfBoundsException e)
           {
       // Print message for user does not exist . 
            }
             showProfileActivity(userId);
            } 
              else {
                   // The query was unsuccessful.
                     }
                       }
                            });