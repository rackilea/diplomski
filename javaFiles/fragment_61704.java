Connection conn = DriverManager.getConnection("foo");
CallableStatement statement = CallableEnum.CALLABLE_ONE.prepare(conn);
for (Cat currentCat : catList) {
    generateCatId(currentCat.name(), currentCat.age(), statement);
}

conn.commit();
conn.close();