for (int i = j + 1; i < studentNames.length; i++) {
                if (studentNames[i].compareTo(studentNames[j]) < 0) {
                    String temp = studentNames[j];
                    studentNames[j] = studentNames[i];
                    studentNames[i] = temp;

                    int tempGrade = studentGrades[j];
                    studentGrades[j] = studentGrades[i];
                    studentGrades[i] = tempGrade;
                }

            }