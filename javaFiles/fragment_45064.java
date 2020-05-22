query.findInBackground(new FindCallback<ParseObject>() {
    @Override
    public void done(List<ParseObject> list, ParseException e) {
        if (e == null) {
            for (int i = 0; i < list.size(); i++) {

                items.add(list.get(i).getString("item"));
                Log.i("KOTB", list.get(i).getString("item"));

                itemDesc.add(list.get(i).getString("description"));
                simpleID++;