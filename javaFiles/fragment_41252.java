class Assignment {

    private String id;
    private List<Activity> activities; //getters and setters for this.

    public String getId() {
        return id;
    }

}

class Activity {
    private String activity; //Getters and setters
}


Gson mGson= new Gson();
assignmentList=mGson.fromJson(json, AssignmentList.class);
assignmentList.getAssignments().get(0).getActivities.get(1);