@Override
      public void done(List<ParseUser> parseUsers, ParseException e) {
                                if (!parseUsers.isEmpty()) {
                                        // The query was successful.
                                        ParseUser user = parseUsers.get(0);
                                        String userId = user.getObjectId();
                                        showProfileActivity(userId);

                                } else {
                                    // The query was unsuccessful.

                                }
                            }
                        });