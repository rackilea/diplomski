double days = 22.5;
long seconds = Math.round(days * 86400);
String text = seconds/86400 + " days, "
           + seconds / 3600 % 24 + " hours, "
           + seconds / 60 % 60   + " minutes, "
           + seconds % 60        + " second.";