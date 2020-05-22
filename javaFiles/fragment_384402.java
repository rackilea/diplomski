import org.joda.time.* ; 

def start = new Date().parse("dd/MM/yy","14/08/2009");
def end = new Date().parse("dd/MM/yy","14/09/2009");

println("date range ${start} - ${end}");

def diff = end - start ; 
println("diff : ${diff} days ");
println("how many weeks : ${diff/7}");

def payDay = 2 ; // Monday = 1 Sunday = 0  

def startDay = new DateTime(start).dayOfWeek ; // 5 = Thursday 

def startDayDiff = payDay - startDay ; 
if(startDay > payDay){
   startDayDiff = 7 + payDay - startDay ;
}

// for example if end on Friday (5) while Pay day is day 1 (Monday) then 
// make sure end date is on Monday (same week )
// end date = end - ( endDay - payDay)


def endDay = new DateTime(end).dayOfWeek;
println("original end day: ${endDay}");
def endDayDiff = endDay - payDay ; 

// otherwise ... if endDay < payDay (for example PayDay = Friday but End day is on Monday)
// end date = end - 7 + payDay 
if(endDay < payDay){
   endDayDiff =  7 - endDay - payDay ;
}
println("endDayDiff : ${endDayDiff}");
println("startDayDiff:  ${startDayDiff}");

def startedOn = new DateTime(start).plusDays(startDayDiff);
println("started on : ${startedOn.toDate()}");

def endOn = new DateTime(end).minusDays(endDayDiff);
println("End on : ${endOn.toDate()}");

println("occurences :  ${Weeks.weeksBetween(startedOn,endOn).getWeeks()+1}");