Duration.between(
    myEarlierInstant ;       // Some earlier `Instant`. 
    Instant.now() ;          // Capture the current moment in UTC. 
)
.compareTo(                  // Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
    Duration.ofMinutes( 5 )  // A span of time unattached to the timeline. 
)
> 0