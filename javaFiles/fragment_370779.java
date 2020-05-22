@Component
class MyClass {
   private final HikariConfiguration hikariConfiguration;  
   private DataSource springDatasource;

   MyClass(final HikariConfiguration hikariConfiguration) {
      this.hikariConfiguration = hikariConfiguration;
   }

   ...

   private DataSource privateSingletonDataSource() {
      if (Objects.isNull(this.springDatasource)) {
         this.springDatasource = buildDataSource(this.hikariConfiguration);
      }

      return this.springDatasource;
   }
}