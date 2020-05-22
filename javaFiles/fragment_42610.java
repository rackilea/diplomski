$ diff Original.java WorkerTest.java 
48c48
<         String name;
---
>         Boolean checked;
91c91
<                     return row.name;
---
>                     return row.checked;
105a106,116
>         @Override
>         public Class<?> getColumnClass(int colIndex) {
>             switch (colIndex) {
>                 case 0:
>                     return Integer.class;
>                 case 1:
>                     return Boolean.class;
>             }
>             return null;
>         }
> 
114c125
<                         r.name = rs.getString(2);
---
>                         r.checked = rs.getBoolean(2);
138c149
<             st.execute("create table city(id integer, name varchar2)");
---
>             st.execute("create table city(id integer, checked boolean)");
143,144c154
<                 ps.setString(2, (char) ('A' + r.nextInt(26))
<                     + String.valueOf(r.nextInt(1_000_000)));
---
>                 ps.setBoolean(2, Boolean.valueOf(r.nextBoolean()));