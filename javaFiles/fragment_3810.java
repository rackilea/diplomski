for (int i = 0; i < classOne.students.size(); i++) {
      int studentIdTest = classOne.students.get(i).getStudentID();
        if (studentIdTest == studentID) {
            studentIndex = i;
            break;
        } else{
            studentIndex = -1;
        }
  }