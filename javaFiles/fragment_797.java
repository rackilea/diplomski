if(AccessToken.getCurrentAccessToken() != null)
{
    GraphRequest graphRequest = GraphRequest.newGraphPathRequest(
            AccessToken.getCurrentAccessToken(),
            "me/taggable_friends",
            new GraphRequest.Callback()
            {
                @Override
                public void onCompleted(GraphResponse graphResponse)
                {
                    //Your code

                    if(graphResponse != null)
                        {
                            JSONObject jsonObject = graphResponse.getJSONObject();
                            String taggableFriendsJson = jsonObject.toString();
                            Gson gson = new Gson();
                            TaggableFriendsWrapper taggableFriendsWrapper= gson.fromJson(taggableFriendsJson, TaggableFriendsWrapper.class);
                            ArrayList<TaggableFriends> invitableFriends = new ArrayList<TaggableFriends>();
                            invitableFriends = taggableFriendsWrapper.getData();
                            int i;
                            for(i = 0; i < invitableFriends.size(); i++)
                            {
                                try
                                {
                                    MainActivity.myMenu.add(invitableFriends.get(i).getName());
                                }
                                catch(Exception e){}
                            }
                            MainActivity.myMenu.add("Tot: " + i);
                        }else {

                        }
                        //response.get

                }
            }
        );

        Bundle parameters = new Bundle();
        parameters.putInt("limit", 5000); //5000 is maximum number of friends you can have on Facebook

        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }