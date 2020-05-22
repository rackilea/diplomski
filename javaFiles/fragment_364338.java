// This is used to Start the ApplicationContext Container and to get the Bean of AbcCotroller

ApplicationContext context = 
new ClassPathXmlApplicationContext("[servlet-name]-servlet.xml");

abcController obj = (abcController) context.getBean("abcController");