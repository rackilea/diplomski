String str = "15";
int minutes = Integer.parseInt(str);
if (minutes < 60)
    str += "Mins";
else
    str = (minutes/60) + "Hrs";