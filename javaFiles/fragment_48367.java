if (timeTaken > 0)   // <- PROBLEM, Shouldn't be zero
    {
        worstTime = timeTaken;
    }
    else if (timeTaken < bestTime) //<- PROBLEM! , the 2 comparisons are unrelated
    {
        bestTime = timeTaken;
    }