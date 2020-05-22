SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
String fromDate= format.parse(from_date);
String toDate= format.parse(to_date);


Query query = session.createQuery("FROM Order_headers oh WHERE oh.merchant_code = :merchant_code AND oh.branch_code = :branch_code AND oh.order_date BETWEEN fromDate AND toDate");

query.setParameter( "fromDate", fromDate);
query.setParameter( "toDate", toDate );