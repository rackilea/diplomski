String fields = "name[Employee Name], employeeno[Employee No], dob[Date of 
Birth], joindate[Date of Joining]";

Pattern pattern = Pattern.compile("\\[.+\\]+?,?\\s*" );

String[] split = pattern.split(fields);