UserDetails m2= new UserDetails();
m2.setUserid(1);
m2.setSort(paths_Vvalue[position]);
//m2 adult is default `false`
//m2 noti is default `false`
...
realm.insertOrUpdate(m2);