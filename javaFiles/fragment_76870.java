for (int i = j + 1; i < studentNames.length; i++) {
                if (studentNames[i].compareTo(studentNames[j]) < 0) {
                    String temp = studentNames[j];
                    studentNames[j] = studentNames[i];
                    studentNames[i] = temp;


                }

            }