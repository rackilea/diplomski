public ITimeSpan intersectionWith(ITimeSpan timeSpan) {

ITime begintime, endtime;
if (bt.compareTo(timeSpan.getBeginTime()) > 0) {
    begintime = bt;
} else {
    begintime = timeSpan.getBeginTime();
}

if (et.compareTo(timeSpan.getEndTime()) < 0) {
    endtime = et;
} else {
    endtime = timeSpan.getEndTime();
}
// aangepast van >= naar <= 
if (begintime.compareTo(endtime) <= 0) {
    return null;
}
//i think the culprit is here, plz print the begintime, endtime and check what are the values its passing other than this everything is working fine
return new TimeSpan(begintime, endtime);
}