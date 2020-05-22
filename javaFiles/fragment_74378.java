public void loadActiveList(String variable){

     Inactive.collapseGroup(AlarmPosition);
     listDataHeaderInactive.remove(variable);
     listAdapter.notifyDataSetInvalidate();

listDataHeaderActive.add(variable)
ActiveList.notifyDataSetChanged();
}