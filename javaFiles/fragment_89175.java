SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String date1 = datepickerfrom.getValue().toString();
    String date2 = datepickerto.getValue().toString();
    try {
        Date d1 = myFormat.parse(date1);
        Date d2 = myFormat.parse(date2);

        while( d1.before(d2) ){
            d1 = addDays(d1, 1);
            allDates.add(d1);
            allDatesString.add(formatter.format(d1));
        }
        //System.out.println(allDatesString);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    for(int i = 0; i < allDatesString.size(); i++) {
        String query = "SELECT * FROM DATA WHERE dateofday  = ? AND id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(2, Controller.id_logged_in);
            preparedStatement.setString(1, allDatesString.get(i));
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                ratings.add(resultSet.getFloat("rating"));
            else
                ratings.add(Float.valueOf(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }