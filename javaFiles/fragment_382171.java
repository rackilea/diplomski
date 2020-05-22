// we start with your string minus the three last digits
// which are some internal z/Series cruft
BigInteger bi = new BigInteger    ("CAE7631DC43DC", 16); // 686 stripped off
// then, from tables the website we get the TOD value for start of epoch
// here also, minus the three last digits                                 
BigInteger startOfEpoch70 = new BigInteger ("7D91048BCA000", 16); // 000 stripped off
// using that we calculate the offset in microseconds in epoch
BigInteger microsinepoch = bi.subtract(startOfEpoch70);
// and reduce to millis
BigInteger millisinepoch = microsinepoch.divide(new BigInteger("1000"));
// which we convert to a long to feed to Joda
long millisinepochLong = millisinepoch.longValue();
// Et voila, the result in UTC
DateTime result = new DateTime(millisinepochLong).withZone(DateTimeZone.UTC);
// Now, if you want a result in some other timezone, that's equally easy
// with Joda:
DateTime result2 = result.toDateTime(DateTimeZone.forID("EET"));

System.out.println("The result is " + result + " or represented in timezone EET "
                   + result2);