myString = new JSONStringer()
 .object()
     .key("Name")
     .value("Apple")
     .key("Expiry")
     .value("Date("+myDate.getTime()+")")
 .endObject()
 .toString();