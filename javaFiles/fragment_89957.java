ParseQuery query = new ParseQuery("ContactObject");
    query.findInBackground(new FindCallback() {
        @SuppressWarnings("unchecked")
        public void done(List<ParseObject> objects, ParseException e) {
            if (e == null) {

                if (objects.toArray().length > 0){
                    _data = new ArrayList<Map<String, String>>();

                    for(int ii=0;ii<objects.toArray().length;ii++){                         
                        ParseObject s = objects.get(ii);
                        Map<String, String> map = new HashMap<String, String>(2);
                        map.put("fname", s.getString("fname"));
                        map.put("lname", s.getString("lname"));
                        map.put("phone", s.getString("phone"));
                        map.put("email", s.getString("email"));
                        map.put("id", s.getObjectId());
                        map.put("fullname", s.getString("fname")+" "+s.getString("lname"));
                        _data.add(map);
                    }