public void addActivity (String aName, String aDate, String aTime) {

    Activity actToAdd = new Activity(aName, aDate, aTime); //create a new instance of the activity called actToAdd, this is a local var that stores methods arguments

    if(activities.containsKey(aDate)){
        activities.get(aDate).add(actToAdd);
    } else {
       ArrayList<Activity> activitiesList = new ArrayList<>();
       activitiesList.add(actToAdd);
       activities.put(aDate, activitiesList); //Add this instance to your Map
    }
}