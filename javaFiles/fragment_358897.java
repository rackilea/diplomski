AbstractRefreshableConfigApplicationContext ctx = new ClassPathXmlApplicationContext(); // init empty
Properties ftpSessionProps = new Properties();
ftpSessionProps.setProperty("user", "first");

StandardEnvironment env = new StandardEnvironment();
env.getPropertySources().addLast(new PropertiesPropertySource("pops", ftpSessionProps));
ctx.setEnvironment(env);
ctx.setConfigLocation("classpath:main.xml"); // set the config here
ctx.refresh();
ctx.start();