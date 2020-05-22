Connection conn = DriverManager.getConnection("foo");
for (Cat currentCat : catList) {
    CallableEnum.CALLABLE_ONE.execute(conn, currentCat.name(), currentCat.age());
}
conn.commit();
conn.close();