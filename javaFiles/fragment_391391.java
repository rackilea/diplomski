//Compute the time diff
Map<TimeUnit, Long> deltaTime = computeDiff(now.getTime(), target.getTime());

//Get the specific values            
long d = deltaTime.get(TimeUnit.DAYS);
long m = deltaTime.get(TimeUnit.MINUTES); 
long s = deltaTime.get(TimeUnit.SECONDS);