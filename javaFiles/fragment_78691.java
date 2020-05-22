Let me write a sample below: First block is for finding followers of a particular tweet user.

    long lCursor = -1, nextCursor = -1;
    IDs friendsIDs = null;

    followerIDListOfOriginalTweeter = new ArrayList<>();

            do
            {
                lCursor = nextCursor;
                try
                {
                    friendsIDs = twitterObj.getFollowersIDs(originalTweetUserId, lCursor);
                }
                catch (Exception ex)
                {
                    logWriter.Write(ex);
                }

                nextCursor = friendsIDs.getNextCursor();

             } while (nextCursor != 0);


The second block is for finding followers of followers:

    IDs friendsIDs = null;
    long lCursor = -1, nextCursor = -1;

    try
        {
            do
              {
                    followers = new Followers();

                    nextCursor = -1;

                    do
                    {
                        lCursor = nextCursor;

                        try
                        {
                friendsIDs = twitterObj.getFollowersIDs(followers.currentUserId, lCursor);
                        }
                        catch (Exception ex)
                        {
                          logWriter.Write(ex);

                        }

                        for (long followerId : friendsIDs.getIDs())
                        {                            
                           system.out.println(followerId);
                        }

                        nextCursor = friendsIDs.getNextCursor();

                    } while (nextCursor != 0);

            } while (rsForSelectNotCompletedRetweetsQuery.next());