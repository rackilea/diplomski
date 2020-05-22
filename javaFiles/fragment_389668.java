public class PrincipalFinderImpl implements PrincipalFinder
{
    private CodeFinder codeFinder;
    public PrincipalFinderImpl(CodeFinder codeFinder) {
        this.codeFinder = codeFinder;
    }
    public String findPrincipal(List<DocumentKey> documentkeys_) {
        Hashtable<String, Integer> codecounts = new Hashtable<String, Integer>();
        for (DocumentKey document : documentkeys_) {
            int x = 0;
            String closestCode = codeFinder.getClosestDocumentCode(document.candidates);
            if (closestCode == null) continue;
            int thecount = 0;
            if (codecounts.containsKey(closestCode))
                thecount = codecounts.get(closestCode);
            if (document.hasKey)
                thecount += 2;
            else
                thecount++;
            codecounts.put(closestCode, new Integer(thecount));
            x++;

        }
        String closestCode = codeFinder.getClosestCode(codecounts);
        return closestCode;
    }
}