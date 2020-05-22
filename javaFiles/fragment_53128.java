private void add2TaskMap(CsSectionDetail csDetail, Map<Integer, Map<Integer,CsSectionDetail>> map) {
    Map<Integer,CsSectionDetail> submap;
     Integer key = csDetail.getProjectTaskId().getId();

     submap =map.get(key);
     if (submap == null) {
         submap = new HashMap<Integer,CsSectionDetail>();
         map.put(key, submap);
     }
     add2SubTaskMap(csDetail, submap);
}

private void add2SubTaskMap(CsSectionDetail csDetail, Map<Integer,CsSectionDetail> map) {
     Integer key;
     if (csDetail.getProjectSubTaskId() == 0) {
         key = csDetail.getProjectTaskId().getId();
     } else {
         key = new Integer(csDetail.getProjectSubTaskId());
     }

     map.put(key, csDetail);
}