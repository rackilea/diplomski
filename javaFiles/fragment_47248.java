public static String displayCandidate(Candidate[] candidate)
{
    System.out.println("Please enter the name of the candidate (LAST,FIRST)");                                      
    Candidate candidateChoice = searchCandidate(candidate);
    return candidateChoice.getInformation();
}