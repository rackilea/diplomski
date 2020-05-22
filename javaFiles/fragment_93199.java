String ncourseIds = equivalentCourses.stream()
   .filter(equivalentCourse -> equivalentCourse.getNcourse() != null)
   .map(EquivalentCourse::getNcourse)
   .map(x -> String.valueOf(x.getId()))
   .collect(Collectors.joining(", "));

String pastCourseIds = equivalentCourses.stream()
   .filter(equivalentCourse -> equivalentCourse.getNcourse() == null
          && equivalentCourse.getPastCourse() != null)
   .map(EquivalentCourse::getPastCourse)
   .map(x -> String.valueOf(x.getId()))
   .collect(Collectors.joining(", "));