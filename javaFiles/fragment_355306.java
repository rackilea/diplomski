SimpleDateFormat formatter1 = new SimpleDateFormat("MM-dd-yyyy HH:mm X");       
    try {
        datePicked = formatter1.parse(request.getParameter("sendTime"));
        System.out.println("Retrieved and formatted dateTime: " + datePicked.toString());
    } catch (ParseException e1) {
        System.out.println("Date formatter failed to parse chosen sendTime.");
        e1.printStackTrace();
    }
    DateTime dt = new DateTime(datePicked);