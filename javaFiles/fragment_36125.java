public void sort(final String field, List<ItemLocation> itemLocationList) {
    Collections.sort(itemLocationList, new Comparator<ItemLocation>() {
        @Override
        public int compare(ItemLocation o1, ItemLocation o2) {
            if(field.equals("icon")) {
                return o1.icon.compareTo(o2.icon);
            } if(field.equals("title")) {
                return o1.title.compareTo(o2.title);
            } else if(field.equals("message")) {
                return o1.message.compareTo(o2.message);
            } 
            .
            . fill in the rest of the fields...
            .
            else if(field.equals("locSeen")) {
                return o1.locSeen.compareTo(o2.locSeen);
            } 
        }           
    });
}