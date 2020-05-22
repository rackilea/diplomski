private void setListViewAdapterToDate(int month, int year, int dv)
{
    setListView(month, year, dv); 
     if(summaryAdapter != null) {
        summaryAdapter.clear();
        summaryAdapter.addAll( summaryList );
        summaryAdapter.notifyDataSetChanged();
     } else {
         summaryList.addAll(Arrays.asList(summary_data));
         summaryAdapter = new SummaryAdapter(this.getActivity().getApplicationContext(), R.layout.listview_item_row, summaryList);
     }
    calendarSummary.setAdapter(summaryAdapter);
}