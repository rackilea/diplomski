String s = "MAT:TO:My address email;SUB:My title;BODY:My content;;";
String[] arrayString = s.split(";");

String email = arrayString[0];
String title = arrayString[1];
String body = arrayString[2];

email= email.substring(email.indexOf("MAT:TO:") + 7, email.length());
title= title.substring(title.indexOf("SUB:") + 4, title.length());
body= body.substring(body.indexOf("BODY:") + 5, body.length());