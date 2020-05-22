#Example
    private void init() 
    {
        ScheduleExpression Expression = new ScheduleExpression();
        #This means twice per hour {0,2,4, ... 22} ~ since it ends on 23h: 
        expression.second(0).minute(0).hour(*/2).month(*).dayOfWeek(*);
        stopTimer();
        Timer timer = service.createCalendarTimer(exp);
    }