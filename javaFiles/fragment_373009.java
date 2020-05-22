import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class DbPropertySourcesPlaceholderConfigurer extends PropertyPlaceholderConfigurer 
{
   private static final String DEFAULT_DATASOURCENAME = "dataSource";
   private static final String DEFAULT_DBTABLENAME = "property";
   private static final String DEFAULT_DBKEYCOLUMNNAME = "key";
   private static final String DEFAULT_DBVALUECOLUMNNAME = "value";
   String dataSourceName;
   String dbTableName;
   String dbKeyColumnName;
   String dbValueColumnName;
   @Override
   public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
   {

      DataSource dataSource = (DataSource) beanFactory.getBean(getDataSourceName());
     // DbProperties dbProps = new DbProperties(dataSource);
      final Properties dbProps = new Properties();
      dbProps.put("app.version", "v3");
      setProperties(dbProps);
      super.postProcessBeanFactory(beanFactory);
   }

   public String getDataSourceName() {
      return dataSourceName==null?DEFAULT_DATASOURCENAME:dataSourceName;
   }

   public void setDataSourceName(String dataSourceName) {
      this.dataSourceName = dataSourceName;
   }


}