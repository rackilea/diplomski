for (PodStatusFragment f : fragArray) {
    podSelectedLines[jobCounter] = ""; // Was null.
    System.out.println("Job " + (jobCounter+1) + " ;;; ");
    String [] selects = f.getSelections();
    for (String s : selects) { //there are 6 to go through
        podSelectedLines[jobCounter] += s.substring(0, Globals.getPodCodeLen());
        System.out.println(s.substring(0, Globals.getPodCodeLen()));
    }
    jobCounter++;
}