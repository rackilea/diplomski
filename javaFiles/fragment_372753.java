ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                "ClassName");
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> list, ParseException e) {
                // TODO Auto-generated method stub
                if (e == null) {
                    // hear u will get responce.
                    for (ParseObject parseObject : list) {
                        ParseFile image = (ParseFile) parseObject.get(""); // hear
                                                                            // set
                                                                            // column
                                                                            // name
                                                                            // same
                                                                            // as
                                                                            // parse
                                                                            // table
                        if (image != null) {
                            // hear store image into your custom array.
                            // Like...
                            Log.e("get Image ",
                                    " IMAGE URL IS " + image.getUrl());
                        }
                    }

                    // and hear u can set your adapter
                    // and yr grid view
                    // in adapter to use Picasso libary for image shower.
                    // how to use picasso lib.
                    Picasso.with(getApplicationContext()).load("image url")
                            .fit().into(imageview);
                } else {
                    // hear is yr fail responce
                    // e.getMessage()
                }

            }
        });