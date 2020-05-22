List segments = userSegmentDAO.getDateWiseCount(org.getOrgId());
System.out.println("List size"+segments.size());
//  IRUserSegment itr=segments.get(1);//getting Iterator from arraylist to traverse elements  
for (int i = 0; i < segments.size(); i++) {
    IRUserSegment value = (IRUserSegment)segments.get(i);
    System.out.println("Element: " + value.getCount());
}