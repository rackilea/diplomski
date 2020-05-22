public String[] getWeekSubjects() {
    Set<String> weekSubjects = new HashSet<String>();
    String[] dailySubjects = new timetable().getDailySubjects();
    Collections.addAll(weekSubjects, dailySubjects);

    // Add the other daily subjects... (somehow)    
    return weekSubjects.toArray(new String[0]);
}