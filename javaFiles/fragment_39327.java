cal.setOnDayClickListener(new OnDayClickListener() {
        @Override
        public void onDayClicked(AdapterView<?> adapter, View view,
                int position, long id, Day day) {

            dayIsClicked = true;
            clickedDay = day;
            getScheduleDetails(day);

            list.setAdapter(new ListaAdapter(context, R.layout.itemlist,
                            itemsList));

                }

            }

    });

private void getScheduleDetails(Day day) {

itemsList = new ArrayList();

for (Event e : day.getEvents())
{   
    itemsList.add(e);
}