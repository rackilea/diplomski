mydb.drop.url = jdbc:derby:memory:mydb;drop=true

    ...

    <bean id="mydbDropUrl" class="java.lang.String">
    <constructor-arg value="${mydb.drop.url}" />
</bean>

    ...

    @Resource
private String mydbDropUrl;        

    @After
public void tearDown() {
    try {
        DriverManager.getConnection(mydbDropUrl);
    } catch (SQLException e) {
        // ignore
    }
}