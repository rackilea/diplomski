String line=null;
    List<Course> courses = new ArrayList<>();
        while ((line = inputFile.readLine())!= null) {
            String[] arrayLine= line.split("\\s+"); // here you are splitting with whitespace 
            courseName = arrayLine[0]
            lName=arrayLine[1];
            officeNumber=arrayLine[2];
            list.add(new Course(courseName,lName,officeNumber));   
          // you sure want do something with this create an object for example

        }

 // in some part br.close();