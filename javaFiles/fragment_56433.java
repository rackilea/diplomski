int x = selectedTimeStamp.length() - selectedTimeStamp.lastIndexOf('.');

if (x==2)
    selectedTimeStamp += "00";
if (x==3)
    selectedTimeStamp += '0';