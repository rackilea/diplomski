for (ParseUser user : ob) {

                    // Save the object to make sure the objectId is generated!
                    user.save();

                    ParseFile profilePicture = (ParseFile) user.get("profilePicture");
                    SuggestedUser map = new SuggestedUser();
                    map.setName((String) user.get("name"));
                    map.setUsername((String) user.get("username"));

                    if(profilePicture != null) {
                        map.setProfilePicture(profilePicture.getUrl());
                    }

                    // Do not retrieve the objectId as a string, rather use the built-in Parse request, i.e. getObjectId();.
                    map.setObjectId((String) user.getObjectId());
                    worldpopulationlist.add(map);
                }