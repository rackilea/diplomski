PreparedStatement ps = connection.prepareStatement(
    "insert into invoice(id, list, dateIn, timeIn, totalCost)"+
    " values (seq_ID_invoice.nextval, shoping_list(item(?,?), item(?,?)), TO_DATE(?,'YYYY-MM-DD'), time(?, ?, ?), ?)");

ps.setInt(1, int_value_for_id_of_item_1);
ps.setInt(2, int_value_for_counter_of_item_1);
ps.setInt(3, int_value_for_id_of_item_2);
ps.setInt(4, int_value_for_counter_of_item_2);
ps.setString(5, string_value_for_date);
ps.setInt(6, int_value_for_year_of_time);
ps.setInt(7, int_value_for_month_of_time);
ps.setInt(8, int_value_for_second_of_time);
ps.setInt(9, int_bvalue_for_total_cost);

int rowCnt = ps.executeUpdate();  
System.out.println(rowCnt+" rows affected.");