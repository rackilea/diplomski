public int compare(MiniUser u1, MiniUser u2)
{
    // order by match
    boolean u1Matches = checkMatchConditions(u1, user);
    boolean u2Matches = checkMatchConditions(u2, user);

    if (u1Matches != u2Matches)
    {
        // put matching ones first
        return u1Matches ? -1 : 1;
    }
    else if (u1Matches)
    {
        // order by dates
        boolean u1HasDate = u1.getLastMatchDate() != null;
        boolean u2HasDate = u2.getLastMatchDate() != null;

        if (u1HasDate != u2HasDate)
        {
            // put the ones without date first
            return u1HasDate ? 1 : -1;
        }
        else if (u1HasDate)
        {
            // order chronologically
            return u1.getLastMatchDate().compareTo(u2.getLastMatchDate());
        }
        else
        {
            // no dates, no order possible
            return 0;
        }
    }
    else
    {
        // both don't match, no order possible
        return 0;
    }
}