JDBCSampler jdbcSampler = new JDBCSampler();
jdbcSampler.setName("JDBC Request");
jdbcSampler.setProperty("dataSource", "foo");
jdbcSampler.setProperty("queryType", "Select Statement");
jdbcSampler.setProperty("query", "select * from help_topic limit 5;");
jdbcSampler.setProperty(TestElement.TEST_CLASS, JDBCSampler.class.getName());
jdbcSampler.setProperty(TestElement.GUI_CLASS, TestBeanGUI.class.getName());