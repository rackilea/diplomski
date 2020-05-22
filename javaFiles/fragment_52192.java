final ArrayList<String> Hashtagtypes = new ArrayList<String>();

                ParseQuery<ParseObject> hashtag = ParseQuery
                        .getQuery("HashTagType");
                hashtag.whereExists("TypeName");

                hashtag.findInBackground(new FindCallback<ParseObject>()

                {

                    public void done(List<ParseObject> NameList, ParseException e)

                    {

                        if (e == null)

                        {
                            if (NameList.size() > 0) {

                                for (int i = 0; i < NameList.size(); i++) {

                                    parsedata map = new parsedata();

                                    ParseObject p = NameList.get(i);
                                    String name = p.getString("TypeName");
                                    // String tagid=p.getObjectId();
                                    map.setHashtag(name);

                                    Hashtagtypes.add(name);

                                     ParseQuery<ParseObject> query =
                                     ParseQuery.getQuery("HashTag");
                                     query.whereEqualTo("Type", name);

                                     query.include("parent");
                                     query.setLimit(2);

                                     try {


                                     List <ParseObject>ob = query.find();

                                     StringBuilder sb = new StringBuilder();

                                     for (ParseObject country : ob) {
                                     // Locate images in flag column


                                     country.get("Tag");
                                     sb.append(country.getString("Tag"));


                                     }
                                     // map.setHashtag(sb.toString());

                                     // totaltaglist.add(map);
                                     tagsdata.add(sb.toString());


                                     }

                                     catch (ParseException e1) {
                                     // TODO Auto-generated catch block
                                     e1.printStackTrace();
                                     }


                                }


                            }

                        }

                    }

                });