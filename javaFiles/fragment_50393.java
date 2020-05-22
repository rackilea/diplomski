factory =
                new ParseQueryAdapter.QueryFactory<MY_MODEL>() {
                    public ParseQuery< MY_MODEL > create() {

                        ParseQuery<MY_MODEL> query = MY_MODEL.getQuery();
                        query.include("user");

                        //Filter by date
                        query.whereGreaterThan("createdAt", midnight);
                        query.whereLessThan("createdAt", now);

                        query.orderByDescending("createdAt");


                        return query;
                    }
                };

        adapter = new MyQueryAdapter(factory, true);