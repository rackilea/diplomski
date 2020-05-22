$totalMinutes: Long(longValue > 40 * 60 )       
    accumulate( 
        ScheduleTime( 
            teacher != null, 
            teacher.id == $tId
        ),sum(minutes)
    )   
then    

    System.out.println("totalDuration for teacher: " + $totalMinutes/60);
    scoreHolder.penalize(kcontext, $totalMinutes/60- 40);