public static JsonObject weeksEventsGraph(){
    ThisWeek week = GetTime.weekDates();
    Calendar cal = Calendar.getInstance();
    JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
    JsonObject data = null;

    sql ="SELECT DATE(`eventApprovedOn`) AS eventDate, sum(`eventId`) as total FROM " +
        "events WHERE DATE(eventApprovedOn) >= ? AND DATE(eventApprovedOn) <= ? " +
        "AND `eventStatus` = 1 GROUP BY `eventApprovedOn`";

    try {
        preparedStatement = DatabaseUtilities.createConnection(sql);
        preparedStatement.setString(1,week.getStart());
        preparedStatement.setString(2,week.getEnd());
        resultSet = preparedStatement.executeQuery();

        for(int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
            cal.set(Calendar.DAY_OF_WEEK, i);
            String date = df.format(cal.getTime());//Returns Date

            if(resultSet.isFirst()){
                 System.out.print(date +"   "+ resultSet.getString("eventDate"));
                while(resultSet.next()){
                    if(resultSet.getString("eventDate").equals(date)){
                        JsonObject dayObj = Json.createArrayBuilder();
                        dayObj.add(date);
                        dayObj.add(resultSet.getInt("total"));
                        jsonArrayBuilder.add(dayObj);
                        break;
                    }else{
                        //if the end of resultset is reached and the date has no value, set it to zero
                        if(resultSet.isLast()){
                            JsonObject dayObj = Json.createArrayBuilder();
                            dayObj.add(date);
                            dayObj.add(0);
                            jsonArrayBuilder.add(dayObj);
                        }
                    }
                } //end of while loop
            }else{
                JsonObject dayObj = Json.createArrayBuilder();
                dayObj.add(date);
                dayObj.add(0);
                jsonArrayBuilder.add(dayObj);
            }
        }//end of date loop

        System.out.print(jsonArrayBuilder);

    } catch (SQLException ex) {
        Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        DatabaseUtilities.closeConnection(resultSet, preparedStatement);
    }

    return data;
}