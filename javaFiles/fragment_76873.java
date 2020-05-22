for (int i = j + 1; i < students.length; i++) {
                if (students[i].compareTo(students[j]) < 0) {
                    Student temp = students[j];
                    students[j] = students[i];
                    students[i] = temp;

                }

            }