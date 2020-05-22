Arrays.sort(ev.field, new Comparator<Event>(){
    @Override
    public int compare(Event e1, Event e2) {
        return Integer.compare(e1.index, e2.index)
    }
});