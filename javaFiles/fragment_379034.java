Calendar cal = Calendar.getInstance();
for(int i=0; i < diff; i ++){
     cal.setTime(DateUtil.toUtilDate(request.getAttribute("txtEffectiveDate").toString()));
     cal.add(Calendar.DATE, i + 1);
     java.util.Date newDate = cal.getDate();
     //     Display that new date as column
}