Calendar cal = Calendar.getInstance();
Date today = cal.getTime();

if(lastPasswordModifiedDate == null)
// put today in database as lastModifiedDate and return

Date lastPasswordModifiedDate =new SimpleDateFormat("MM/dd/yyyy").parse("10/30/2013");
lastPasswordModifiedDate.add(Calendar.DAY_OF_MONTH,  30); //max 30 dates to expire
if(today.after(lastPasswordModifiedDate))
// password expired
else
// password valid