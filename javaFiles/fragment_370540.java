this code does

package cassspark.clt;

import java.io.*;
import javafx.application.Application;
import java.util.concurrent.Executors ;
import java.util.concurrent.ExecutorService;
import org.apache.cassandra.service.CassandraDaemon;
import com.datastax.driver.core.exceptions.ConnectionException;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.apache.spark.sql.SparkSession;

public class EmbeddedCassandraDemo extends Application {

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private CassandraDaemon cassandraDaemon;

    public EmbeddedCassandraDemo() {
    }

    public static void main(String[] args) {
        try {
            new EmbeddedCassandraDemo().run();
        }
        catch(java.lang.InterruptedException e)
        {
            ;
        }
    }

    @Override public void start(javafx.stage.Stage stage) throws Exception
    {
        stage.show();
    }

    private void run() throws InterruptedException, ConnectionException {
        setProperties();
        activateDeamon();
    }

    private void activateDeamon() {
        executor.execute( new Runnable() {

            @Override
            public void run() {
                cassandraDaemon = new CassandraDaemon();
                cassandraDaemon.activate();
                SparkSession spark = SparkSession .builder().master("local").appName("ASH").getOrCreate();
            }
        });
    }

    private void setProperties() {

        final String yaml = System.getProperty("user.dir") + File.separator +"conf"+File.separator+"cassandra.yaml";
        final String storage = System.getProperty("user.dir") + File.separator +"storage" + File.separator +"data";

        System.setProperty("cassandra.config", "file:"+ yaml );
        System.setProperty("cassandra.storagedir", storage );
        System.setProperty("cassandra-foreground", "true");

        String log4JPropertyFile = "./conf/log4j.properties";
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(log4JPropertyFile));
            PropertyConfigurator.configure(p);
        } catch (IOException e) {
            System.err.println("./conf/log4j.properties not found ");
            System.exit(1);
            ;
        }
    }
}