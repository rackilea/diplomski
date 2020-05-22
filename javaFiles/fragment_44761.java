String text = "<table><tr><td><h6>Student Name</h6></td><td><h6>Student ID</h6></td></tr>";
    for(int i=0;i<recentlyJoinedStudents.size();i++) {
        text += "<tr><td>" + recentlyJoinedStudents.get(i).getName() + "</td><td>" 
                + recentlyJoinedStudents.get(i).getId() + "</td><td></tr>";
    }
    text += "</table>";
    System.out.print(text);