Instant myInstant = Instant.now();
    if (myInstant.getNano() > 1000000) //Nano to milliseconds
    {
        myInstant = myInstant.truncatedTo(ChronoUnit.SECONDS).plusSeconds(1);
    }
    else
    {
        myInstant = myInstant.truncatedTo(ChronoUnit.SECONDS); //Must truncate the nanoseconds off since we are comparing to milliseconds now.
    }