@Configuration
class MyConfig {
    @Bean
    DataPropDaoImpl dataPropDao(DataSource datasource) {
        DataPropDaoImpl dao = new DataPropDaoImpl();
        dao.setDataSource(datasource);
        dao.setSql("PROFILE_PKG.GetProfileByCode");
        dao.setFunction(true);
        return dao;
    }
}