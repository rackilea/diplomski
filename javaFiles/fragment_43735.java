public static void main(String[] args) {
        List<String> workDays = new ArrayList<String>();
        int dayOfWeek  = 3; //TuesDay

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        startDate.set(2013, 11, 1);
        endDate.set(2013, 11, 31);

        while (startDate.getTimeInMillis() <= endDate.getTimeInMillis()) {
            if (startDate.get(Calendar.DAY_OF_WEEK) == dayOfWeek) {
                workDays.add(startDate.getTime().toString());
                System.out.println(startDate.getTime());
            }
            startDate.add(Calendar.DAY_OF_MONTH, 1);
        }


    }