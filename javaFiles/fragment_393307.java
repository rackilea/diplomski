Instant myInstant = Instant.now();
    if (myInstant.getNano() > 0) //Checks for any nanoseconds for the current second (this will almost always be true)
    {
        myInstant = myInstant.truncatedTo(ChronoUnit.SECONDS).plusSeconds(1);
    }
    /* else //Rare case where nanoseconds are exactly 0
    {
        myInstant = myInstant;
    } */