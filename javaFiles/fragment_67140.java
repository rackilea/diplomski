// Automatic timer - run every 5 seconds
// It's a automatic (@Schedule) and programmatic (@Timeout) timer timeout method
// at the same time (which is UNUSUAL)
@Schedule(hour = "*", minute = "*", second = "*/5")
@Timeout
public void myScheduler(Timer timer) {

    // This might be checked basing on i.e. timer.getInfo().
    firstSchedule = ...

    if (!firstSchedule) {
        // ordinary code for the scheduler
    } else {

        // Get actual schedule expression.
        // It's the first invocation, so it's equal to the one in @Schedule(...)
        ScheduleExpression expr = timer.getSchedule();

        // Your new expression from now on
        expr.second("*/7");

        // timers is TimerService object injected using @Resource TimerService.

        // Create new timer based on modified expression.
        timers.createCalendarTimer(expr);

        // Cancel the timer created with @Schedule annotation.
        timer.cancel();
    }
}