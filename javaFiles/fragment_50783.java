try {
        String s1 = "00:00:00.221";
        String s2 = "00:00:44.221";
        SimpleDateFormat myformat = new SimpleDateFormat("hh:mm:ss.SSS", Locale.getDefault());
        Date date = myformat.parse(s1);
        Date date1 = myformat.parse(s2);

        long value = date1.getTime() - date.getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.setTime(new Date(value));
        String g1 = String.valueOf(calendar.get(Calendar.HOUR));
        String g2 = String.valueOf(calendar.get(Calendar.MINUTE));
        String g3 = String.valueOf(calendar.get(Calendar.SECOND));
        String g4 = String.valueOf(calendar.get(Calendar.MILLISECOND));
        String res = g1 + ":" + g2 + ":" + g3 + "." + g4;
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
    } catch (Exception e) {
        e.printStackTrace();
    }