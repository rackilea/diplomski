public Map<String, List<Course>> getSourtedLists(){
    Map<String, List<Course>> result = new HashMap<String, List<Course>>();
    while(courseItr.hasNext()) {
        course next = courseItr.next();
        if (!result.containsKey(next.getCourseName())) {
            result.put(next.getCourseName(), new ArrayList<Course>());
        }
        result.get(next.getCourseName()).add(next);
}