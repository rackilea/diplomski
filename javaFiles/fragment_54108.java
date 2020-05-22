private List<Long> timestampList = new ArrayList<>();

for (String dateString : dateArray) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMM-dd");
            Date date = sdf.parse(dateString);

            long startDate = date.getTime();

            Log.d("timestamp:", String.valueOf(startDate));

            timestampList.add(startDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }