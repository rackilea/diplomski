list = new ArrayList<String>();
    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("test");
    query.whereExists("arr");
    query.findInBackground(new FindCallback<ParseObject>() {

        @Override
        public void done(List<ParseObject> objects, ParseException e) {
            // TODO Auto-generated method stub

        if(e==null){

            for(int i=0; i<objects.size();i++){

                list=objects.get(i).getList("arr");

                Log.e("list",list.toString());
                    }
        }

        }
    });