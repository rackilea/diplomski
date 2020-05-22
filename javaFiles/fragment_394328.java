//In my Async-Class where the Files get written
          LocalDate currentDate = LocalDate.now();
          outputStream.write(currentDate.toString().getBytes());


 //In my Main-clasS
    final LocalDate currentDate = LocalDate.now(); //Current Date
    final int daysbetween = 6; //days between current date and date of file
    final int index = openfilewed().indexOf("2", 30); //Date from file
    final LocalDate[] filedate = new LocalDate[1];
    final LocalDate[] reach = new LocalDate[1];

     filedate[0] = LocalDate.parse(openfilemon().substring(index));
     reach[0] = filedate[0].plusDays(daysbetween);
           if (currentDate.isBefore(reach[0])){
              //do something
           }