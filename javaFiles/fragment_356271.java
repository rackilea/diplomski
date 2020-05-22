String timestampString = "152656375.489991";
    timestampString = timestampString.replaceFirst(
            "^(\\d{2})(\\d{2})(\\d{2})(\\d{3})(?:\\.(\\d*))?$", "$1:$2:$3.$4$5");
    System.out.println(timestampString);
    LocalTime time = LocalTime.parse(timestampString);
    System.out.println(time);