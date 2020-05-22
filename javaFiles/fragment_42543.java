public class TimeInterval {
short milliSeconds;
short seconds;
short minutes;
int hours;

public TimeInterval (String dateString) {
    // HHHHHH:MI:SS.SSS
    Pattern pattern = Pattern.compile("(\\d+):(\\d\\d):(\\d\\d)\\.(\\d\\d\\d)");
    Matcher matcher = pattern.matcher(dateString);
    if ( matcher.find() ) {
        hours = Integer.parseInt(dateString.substring(matcher.start(1), matcher.end(1)));
        minutes = Short.parseShort(dateString.substring(matcher.start(2), matcher.end(2)));
        seconds = Short.parseShort(dateString.substring(matcher.start(3), matcher.end(3)));
        milliSeconds = Short.parseShort(dateString.substring(matcher.start(4), matcher.end(4)));
    }
}

private TimeInterval() {
}

public TimeInterval add(TimeInterval interval) {
    TimeInterval ret = new TimeInterval();
    ret.milliSeconds = (short) ((interval.milliSeconds + milliSeconds)%1000);
    int carry = (interval.milliSeconds + milliSeconds)/1000;
    ret.seconds = (short) ((interval.seconds + seconds)%60 + carry );
    carry =(interval.seconds + seconds)/60;
    ret.minutes = (short) ((interval.minutes + minutes)%60 + carry);
    carry = (interval.minutes + minutes)/60;
    ret.hours = (interval.hours + hours + carry);
    return ret;
}

@Override
public String toString() {
    return String.format("%d:%02d:%02d.%03d", hours, minutes, seconds, milliSeconds);
}
}