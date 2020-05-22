MutableDateTime epoch = new MutableDateTime();
epoch.setDate(0); //Set to Epoch time
DateTime now = new DateTime();

Days days = Days.daysBetween(epoch, now);
Weeks weeks = Weeks.weeksBetween(epoch, now);
Months months = Months.monthsBetween(epoch, now);

System.out.println("Days Since Epoch: " + days.getDays());
System.out.println("Weeks Since Epoch: " + weeks.getWeeks());
System.out.println("Months Since Epoch: " + months.getMonths());