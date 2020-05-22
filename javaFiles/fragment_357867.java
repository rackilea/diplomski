String[] dayArray = timeTableMapping.getDay().split(",");
String[] subArray = timeTableMapping.getSubject_code().split(",");  


List<TimeTableMapping> tempList = new ArrayList<>();
for(int i = 0 ; i < dayArray.length; i++) {
    TimeTableMapping tempTimeTable = new TimeTableMapping();
    tempTimeTable.setTime_table_code(timeTableMapping.getTime_table_code());        
    tempTimeTable.setDay(dayArray[i]);
    tempTimeTable.setSubject_code(subArray[i]);
    tempTimeTable.setStart(timeTableMapping.getStart());
    tempTimeTable.setEnd(timeTableMapping.getEnd());
    tempList.add(tempTimeTable);
}   
timeTableMappingDAO.saveAll(tempList);
    return  "redirect:/timeTableMapping";
}