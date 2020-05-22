public static int dayOfWeek(String date) {
        try {
            int day = 0;
            SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy-MM-dd");
            Date now = simpleDateformat.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);
            day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            return day;
        } catch (Exception e) {
            return null;
        }
    }