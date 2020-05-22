Period[] p=new Period[7];
    long hours = 0;
    long minutes =0;
    for(int x=0; x<=this.daysEntered;x++)
    {
        p[x] = new Period(this.startTime[x], this.endTime[x]);
        hours += p[x].getHours();
        minutes += p[x].getMinutes();
    }

    hours += minutes/60;
    minutes=minutes%60;

    String format = String.format("%%0%dd", 2);

    return Long.toString(hours)+":"+String.format(format, minutes);