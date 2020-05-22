public static void main(String[] args) {
    ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
    JdbcDaoImplement dao=ctx.getBean(JdbcDaoImplement.class);
    Rect rect=dao.getRect(1);
    System.out.println(rect.getName());
}