// our "oldest" timestamp is now pre-defined:
long oldestTs = newest.timestamp - ttlTimestamp;  // ttlTimestamp = 60000;
// mesure the difference in age of the newest and the TTL (ex: 60000)
double agediff = newest.timestamp - oldestTs;

// for any given object :
// 1. color ratio from 0.0=old to 1.0=new
double ratio = (someObject.timestamp - oldestTs) / ageDiff;

if (ratio < 0.0) ratio = 0.0;   // prevent overflow

// etc.