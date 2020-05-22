if (userActivities == null) {
      activities = new ArrayList<Activity>();
      userActivities = new Element(userKey, activities);
} else {
      activities = new ArrayList<Activity>((List) userActivities.getObjectValue());
}