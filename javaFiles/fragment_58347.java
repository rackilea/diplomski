1c1
<   public static String getVersion() {
---
>   public static void printVersion() {
10d9
<       String rtn = null;
13d11
<           Class.forName("com.mysql.jdbc.Driver").newInstance();
19c17
<               rtn = rs.getString(1);
---
>               System.out.println(rs.getString(1));
43d40
<       return rtn;