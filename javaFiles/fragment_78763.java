if (!(courseNum == 100 || courseNum == 150 || courseNum == 250 || courseNum == 300)) {
            JOptionPane.showMessageDialog(null, "Enter a valid course number (100/150/250/300)");
            System.exit(0);
        }
        if(courses.contains(courseNum) {
            JOptionPane.showMessageDialog(null, "It is an already selected course number");
            return;
        }
        courses.add(courseNum);
        if (courseNum == 100 && (typeOfStudent.equals("Online"))) {
            totalNumCredits += credits100;
            totalStudentFee += onlineStudentFee100;

        }