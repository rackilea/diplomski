import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import java.util.Properties;
import javax.sql.DataSource;

@Configuration
public class AppConfig {

@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
LocalContainerEntityManagerFactoryBean em =
    new LocalContainerEntityManagerFactoryBean();
em.setDataSource(dataSource());
em.setPersistenceUnitName("PERSISTENT_UNIT_NAME");
em.setPackagesToScan(new String[] { "package.name.to.scan" });

JpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();

em.setJpaVendorAdapter(vendorAdapter);
// here some additional properties for the PU
em.setJpaProperties(additionalProperties());

return em;
}

Properties additionalProperties() {
Properties properties = new Properties();

properties.setProperty("eclipselink.weaving", "false");
properties.setProperty("eclipselink.query-results-cache", "false");
properties.setProperty("eclipselink.cache.shared.default", "false");

properties.setProperty("javax.persistence.jdbc.driver",
    "org.apache.derby.jdbc.EmbeddedDriver");
properties.setProperty("javax.persistence.jdbc.url",
    "jdbc:derby:memory:NAME;create=true");

properties.setProperty("javax.persistence.jdbc.url", "jdbc:derby:PATH");
properties.setProperty("javax.persistence.jdbc.user", "");
properties.setProperty("javax.persistence.jdbc.password", "");

properties.setProperty("javax.persistence.sql-load-script-source",
    "META-INF/sql/createDB.sql");
properties.setProperty("eclipselink.deploy-on-startup", "true");
properties.setProperty("eclipselink.target-database", "Derby");

return properties;
}

public DataSource dataSource() {
DriverManagerDataSource dataSource = new DriverManagerDataSource();
try {
  Class.forName("org.eclipse.persistence.jpa.PersistenceProvider");
  Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
} catch (ClassNotFoundException cnfe) {
  cnfe.printStackTrace();
} catch (InstantiationException inste) {
  inste.printStackTrace();
} catch (IllegalAccessException iace) {
  iace.printStackTrace();
}

dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
dataSource.setUrl("jdbc:derby:memory:NAME;create=true");

dataSource.setUsername("");
dataSource.setPassword("");

return dataSource;
}

}