java.util.Date d;
SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
d = sdf.parse ("2008-07-31");

// or
d = java.sql.Date.valueOf ("2008-07-31");