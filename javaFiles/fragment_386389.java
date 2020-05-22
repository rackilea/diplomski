subjets.stream()
    .forEach(subj-> {
       System.out.println(subj.getSubjectBearer().getName()+ " " + subj.getSubjectBearer().getLastName());
       subj.getStudents().stream()
           .forEach(stud->System.out.println(stud.getName()+" "+stud.getLastName()))
    });