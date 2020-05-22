private ArrayList<TrackingSystem> CreateIssue(ArrayList<TrackingSystem> tracker){
    String issueCreator;
    String a = " ";
    boolean is = true;

    do {
        System.out.println("*** Create an Issue***");
        System.out.println("Describe your Issue: ");
        issueCreator = in.nextLine();


    }while (is);

    TrackingSystem ts = new TrackingSystem(issueCreator,false);
    tracker.add(ts);

    return tracker;
}