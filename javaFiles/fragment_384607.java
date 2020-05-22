ArrayList<Student> allStudentsA = assignStudents();
ArrayList<Student> allStudentsB = allStudentsA;

for (Student studentA : allStudentsA)
    for (Student studentB : allStudentsB)
        if (studentA.getId().equals(studentB.getId())
            && studentA.getEduNumber() != studentB.getEduNumber())
            if (!duplicateStudents.contains(studentB))
                duplicateStudents.add(studentB);