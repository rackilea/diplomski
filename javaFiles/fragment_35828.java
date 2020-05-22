import java.text.SimpleDateFormat;

String dateString = "01/08/1985";

// class definition here, etc...

    formatter = new SimpleDateFormat("MM/dd/yyyy");
    // formatter = new SimpleDateFormat("dd/MM/yyyy");

    a.setDateOfBirth(formatter.parse(dateString));