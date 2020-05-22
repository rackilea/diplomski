Properties prop=new Properties();
prop.put("hibernate.dialect","H2");
prop.put("hibernate.show_sql","true");
prop.put("hibernate.format_sql","true");
prop.put("hibernate.jdbc.batch_size",batchSize);
prop.put("hibernatae.order_inserts","true");
prop.put("hibernatae.order_updates","true");
prop.put("hibernate.jdbc.batch_versioned_data","true");
prop.put("hibernate.id.new_generator_mappings","true");