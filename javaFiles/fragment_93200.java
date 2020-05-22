String ncourseIds = equivalentCourses.stream()
   .map(EquivalentCourse::getNcourse)
   .filter(Objects::nonNull)
   .map(NCourse::getId)
   .map(String::valueOf)
   .collect(Collectors.joining(", "));

String pastCourseIds = equivalentCourses.stream()
   .filter(equivalentCourse -> equivalentCourse.getNcourse() == null)
   .map(EquivalentCourse::getPastCourse)
   .filter(Objects::nonNull)
   .map(EquivalentCourse::getPastCourse)
   .map(PastCourse::getId)
   .map(String::valueOf)
   .collect(Collectors.joining(", "));