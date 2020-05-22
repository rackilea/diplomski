String s = ListModelArrayList.get(j).getInit_Date();
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    Date date = null;
    try {
        date = fmt.parse(s);
        SimpleDateFormat fmtOut = new SimpleDateFormat("dd", Locale.ENGLISH);

        textViewDate.setText(textViewDate.getText() +
                fmtOut.format(date) + "\n");
    } catch (ParseException e) {
        textViewDate.setText(textViewDate.getText() + "\n");
        e.printStackTrace();
    }