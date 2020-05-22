public ArrayList<Event> eventDetails(Context mContext, int m, int d) {

 ArrayList<Event> events = new ArrayList<Event>();
            switch (m) {
               case 1:
                    if (d == 1) {
                        events.add(new Event(mContext.getResources().getString(R.string.text1), null, null, null, null, null, null, null));
                    }
            }

            return events
}