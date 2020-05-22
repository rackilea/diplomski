public synchronized List<Match> getNextPlayingSynchronized(Date startingFrom, Locale locale){
     return getNextPlaying(Date startingFrom, Locale locale);
}
...
@Cacheable(value="nextPlaying", key = "#startingFrom.getYear() + #startingFrom.getMonth() + #startingFrom.getDay() + #startingFrom.getHours() + #startingFrom.getMinutes() + #locale.getLanguage()")
public List<Match> getNextPlaying(Date startingFrom, Locale locale){
...//your old method without the synchronized modifier
}