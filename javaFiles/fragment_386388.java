subjets.stream()
  .forEach(subj-> System.out.println(
      subj.getSubjectBearer().getName()+ " " + 
      subj.getSubjectBearer().getLastName()+" "+
      subj.getStudents().stream()
            .map(stud->stud.getName()+" "+stud.getLastName())
            .collect(Collectors.joining(","))
  ));