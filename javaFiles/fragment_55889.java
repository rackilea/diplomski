import database.Document;
import database.PkgItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class HibernateMapTest {

    private static final String TEST_DIALECT = "org.hibernate.dialect.HSQLDialect";
    private static final String TEST_DRIVER = "org.hsqldb.jdbcDriver";
    private static final String TEST_URL = "jdbc:hsqldb:mem:adportal";
    private static final String TEST_USER = "sa";
    private static final String TEST_PASSWORD = "";

    private HibernateTemplate hibernateTemplate;
    private TransactionTemplate transactionTemplate;

    @Before
    public void setUp() throws Exception {
        hibernateTemplate = new HibernateTemplate();
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.getHibernateProperties().put("hibernate.dialect", TEST_DIALECT);
        sessionFactory.getHibernateProperties().put("hibernate.connection.driver_class", TEST_DRIVER);
        sessionFactory.getHibernateProperties().put("hibernate.connection.password", TEST_PASSWORD);
        sessionFactory.getHibernateProperties().put("hibernate.connection.url", TEST_URL);
        sessionFactory.getHibernateProperties().put("hibernate.connection.username", TEST_USER);
        sessionFactory.getHibernateProperties().put("hibernate.hbm2ddl.auto", "create");
        sessionFactory.getHibernateProperties().put("hibernate.show_sql", "true");
        sessionFactory.getHibernateProperties().put("hibernate.jdbc.batch_size", "0");
        sessionFactory.getHibernateProperties().put("hibernate.cache.use_second_level_cache", "false");

        sessionFactory.setMappingDirectoryLocations(new Resource[]{new ClassPathResource("database")});
        sessionFactory.afterPropertiesSet();

        hibernateTemplate.setSessionFactory(sessionFactory.getObject());

        transactionTemplate = new TransactionTemplate(new HibernateTransactionManager(sessionFactory.getObject()));
    }

    @After
    public void tearDown() throws Exception {
        hibernateTemplate.getSessionFactory().close();
    }

    @Test
    public void testFetchEntityWithMap() throws Exception {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                // Store the entities and mapping
                PkgItem key = new PkgItem();
                key.setName("pkgitem1");
                hibernateTemplate.persist(key);

                Document doc2 = new Document();
                doc2.setName("doc2");
                hibernateTemplate.persist(doc2);

                Document doc1 = new Document();
                doc1.setName("doc1");
                HashMap<PkgItem, Document> documentbundles = new HashMap<PkgItem, Document>();
                documentbundles.put(key, doc2);
                doc1.setDocumentbundles(documentbundles);
                hibernateTemplate.persist(doc1);

                // Now attempt a query
                List results = hibernateTemplate.find("from database.Document d where d.name = 'doc1'");
                Document result = (Document)results.get(0);

                // Check the doc was returned
                Assert.assertEquals("doc1", result.getName());

                key = (PkgItem)hibernateTemplate.find("from database.PkgItem").get(0);
                Set<PkgItem> bundleKeys = result.getDocumentbundles().keySet();

                // Check the key is still present in the map. At this point the test fails because
                // the map contains a proxy object of the key...
                Assert.assertEquals(key, bundleKeys.iterator().next());
            }
        });

    }
}