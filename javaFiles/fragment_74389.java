if (user instanceof Student) {

    ((Student) user).getGrade();

  } else { // it is an instance of a Teacher

    ((Teacher) user).getSubject();
  }