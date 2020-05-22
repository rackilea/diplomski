/** returns the cost of the difference between a tested CharSequence and a target CharSequence. CS = CharSequence
 * @param tested input, the CS which will be compared to the target. all letters sorted by ASCII order and unique
 * @param target is the CS to which the tested will be compared. all letters sorted by ASCII order and unique
 * @param positiveDifferenceCost is the cost to add when a letter is in the tested CS but not in the target.
 * @param negativeDifferenceCost is the cost to add when a letter is in the target CS but not in the tested.
 * @return int the number of differences.
 */


public static int oneSidedOAUDistance(final CharSequence tested, final CharSequence target,
                                      final int positiveDifferenceCost, final int negativeDifferenceCost) {
    int diffCount = 0;
    int index_tested = 0;
    int index_target = 0;

    if (positiveDifferenceCost == 0 && negativeDifferenceCost == 0)
        return 0;


    for (; index_tested < tested.length() && index_target < target.length(); ) {
        if (tested.charAt(index_tested) == target.charAt(index_target)) {
            ++index_tested;
            ++index_target;
            continue;
        }
        if (tested.charAt(index_tested) < target.charAt(index_target)) {
            //some letters should not be there in tested string.
            diffCount+= positiveDifferenceCost;
            index_tested++;

        } else {
            //some letters miss in tested string.
            diffCount+=negativeDifferenceCost;
            index_target++;
        }
    }


    return diffCount;
}