val s = "MAT:TO:My address email;SUB:My title;BODY:My content;;"
val arrayString = s.split(";").toTypedArray()

var email = arrayString[0]
var title = arrayString[1]
var body = arrayString[2]

email = email.substring(email.indexOf("MAT:TO:") + 7, email.length)
title = title.substring(title.indexOf("SUB:") + 4, title.length)
body = body.substring(body.indexOf("BODY:") + 5, body.length)