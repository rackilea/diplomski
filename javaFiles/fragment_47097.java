String Hora = "12:34";
int hour = Integer.parseInt(Hora.substring(0, 2));
int minute = Integer.parseInt(Hora.substring(3));

String Date = "12/34/5678";
int day = Integer.parseInt(Date.substring(0, 2));
int month = Integer.parseInt(Date.substring(3, 5));
int year = Integer.parseInt(Date.substring(6));