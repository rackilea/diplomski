class CalendarEvents{
    final List<FullCalendarData> data=new ArrayList<>();

    public List<FullCalendarData> getData() {
        return data;
    }

    public void addEvent(FullCalendarData event) {
        this.data.add(event);
    }

}