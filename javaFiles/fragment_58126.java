if (StrComp.indexOf("P1")!=-1)
{
            priorityCheck="a.SubscriptionType=0 and a.applyticketpriorityfilterflag = 1 and a.P1 & a.P2 = 1";
}

else if (StrComp.indexOf("P2")!=-1)
{
            priorityCheck="a.SubscriptionType=0 and a.applyticketpriorityfilterflag = 1 and a.P3 & a.P4 = 1";
}
else if (StrComp.indexOf("WO")!=-1)
{
            priorityCheck="a.SubscriptionType=2";
}