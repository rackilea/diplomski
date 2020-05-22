BasicConfigurator.configure();
System.setOut(...);
System.setErr(...);

System.out.println("I fail");
Logger.getLogger(...).info("I work");