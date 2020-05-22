for (PodStatusFragment f : fragArray) {
    StringBuilder status = new StringBuilder();
    System.out.println("Job " + (jobCounter+1) + " ;;; ");
    String [] selects = f.getSelections();
    for (String s : selects) { //there are 6 to go through
        status.append(s.substring(0, Globals.getPodCodeLen()));
    }
    podSelectedLines[jobCounter] = status.toString();
    jobCounter++;
}