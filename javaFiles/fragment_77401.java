SectionOutageListItem[][] exampleArray = new SectionOutageListItem[outnums.size()][2];

for(int i = 0; i < outnums.size(); i++) {
    exampleArray[i][0] = 
  new SectionOutageListItem("Impact", impacted.get(i), "Outage No. " + outnums.get(i));
  exampleArray[i][1] = new SectionOutageListItem("status", status.get(i), "Outage No. " + outnums.get(i));


}
    CustomOutageDetailListAdapter adapter = new CustomOutageDetailListAdapter(this, exampleArray);
    sectionAdapter = new SectionOutageListAdapter(getLayoutInflater(),
            adapter);