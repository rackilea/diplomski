double millisstart = datestart.getTime();
    double millisend = dateend.getTime();
    double millistoday = datetoday.getTime();
    double percent = (((millistoday - millisstart) / (millisend - millisstart)) * 100);
    percentAsString = Double.toString(percent);

    txt5.setText(percentAsString);