while (rs.next()) {               
   BigDecimal money = rs.getBigDecimal("money");
   //if needed set it's scale to something else
   //money=money.setScale(2,RoundingMode.HALF_UP); //2 decimals rounded up
   System.out.println(money);             
}