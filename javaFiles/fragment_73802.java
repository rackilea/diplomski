/**
     * Adds the given time to the current time, producing the sum
     * @param other the given time to add
     * @return the sum of this time and the other time
     */
    public Time add (Time other) 
    {
        int remainder = 0;
        int newSec = this.seconds + other.seconds;

        // if over a minute, carry.
        if (newSec >= 60) {
           remainder = 1;
           newSec -= 60;
        }
        this.seconds = newSec;
        int newMin = this.minutes + remainder + other.minutes;
        remainder = 0;

        // carry if over an hour
        if (newMin >= 60) {
            remainder = 1;
            newMin -= 60;
        }
        this.minutes = newMin;
        this.hours += other.hours + remainder;

        return this;
    }