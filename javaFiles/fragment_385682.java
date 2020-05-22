Collections.sort(datestring, new Comparator<Planning>() {
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy '@'hh:mm a");
        @Override
        public int compare(Planning o1, Planning o2) {
            Date date1 = o1.getStart();
            Date date2 = o2.getStart();
            try {
                return f.parse(date1).compareTo(f.parse(date2));
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }
    });