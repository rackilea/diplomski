public class Breaker{

Long from, to = null;

public Breaker(Long lFrom, Long lTo) {
    this.from = lFrom;
    this.to   = lTo;
}

public void scan() {
    ArrayList<ArrayList<Long>> results = new ArrayList<ArrayList<Long>>();
    Long startingTime = new Long(System.currentTimeMillis() / 1000L);
    for (Long i = this.from; i <= this.to; i++) {
        ArrayList<Long> a = new ArrayList<Long>();
        a = getFriendPair(i);
        if(a != null) {
            results.add(a);
            System.out.println((System.currentTimeMillis() / 1000L) + ": FOUND PAIR! " + a.toString());
        }
    }
}

/**
 * Receives integer and returns an array of the integer and the number who is it's
 * pair in case it has any. Else returns null.
 * @param i
 * @return
 */
private static ArrayList<Long> getFriendPair(Long i) {

    Long possibleFriend = getAndSumAllDevisors(i);
    if (possibleFriend.compareTo(i) <= 0) return null;
    Long sumOfPossibleFriend = getAndSumAllDevisors(possibleFriend);
    if(sumOfPossibleFriend.equals(i)) {
        ArrayList<Long> pair = new ArrayList<Long>();
        pair.add(i);
        pair.add(possibleFriend);

        return pair;
    }
    return null;
}

private static Long getAndSumAllDevisors(Long victim) {
    Long sum = new Long(1);
    Long i = 2L;
    Long k = new Long(0);
    while ((k = i * i) <= victim) {
        if ((victim % i) == 0) {
            sum += i;
            if (k == victim) return sum;
            sum += (victim / i);
        }
        i++;
    }
    return sum;
}
}