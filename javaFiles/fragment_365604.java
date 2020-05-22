Collections.sort(datestring, new Comparator<String>() {
        DateFormat f = new SimpleDateFormat("MM/dd/yyyy '@'hh:mm a");
        @Override
        public int compare(String o1, String o2) {
            try {
                return f.parse(o1).compareTo(f.parse(o2));
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }
    });